/**
 * 导入工具类
 * 根据预先定义的模板将Excel转换成实体
 * 调用方法: ImportUtil.importExcel(clz,table,templateDescribeName)
 * 模板需定义在ImportUtil.ImportDescribe.Holder static块中
 *
 * @author cui
 */
@Component
public class ImportUtil {
    static final Map<Class<?>, Map<String, Field>> FIELD_CACHE = new HashMap<>();

    static IEmployeeService employeeService = AppBeans.getBeans(IEmployeeService.class);

    /**
     * 根据class和属性名获取属性对象
     *
     * @param clz       类名
     * @param fieldName 属性名
     * @return 属性对象
     */
    static Field getField(Class<?> clz, String fieldName) {
        if (FIELD_CACHE.containsKey(clz)) {
            return FIELD_CACHE.get(clz).getOrDefault(fieldName, null);
        } else {
            Map<String, Field> fieldMap = new HashMap<>(10);
            Class<?> clazz = clz;
            while (clazz != null) {
                for (Field field : clazz.getDeclaredFields()) {
                    if (!fieldMap.containsKey(field.getName())) {
                        field.setAccessible(true);
                        fieldMap.put(field.getName(), field);
                    }
                }
                clazz = clazz.getSuperclass();
            }
            FIELD_CACHE.put(clz, fieldMap);
            return getField(clz, fieldName);
        }
    }

    /**
     * 将List<List<String>>转换成实体列表
     *
     * @param clz                  实体类型
     * @param table                导入数据
     * @param templateDescribeName 模板描述名称
     * @param <T>                  实体类型
     * @return 实体列表
     */
    public static <T> List<T> importExcel(Class<T> clz, List<List<String>> table, String templateDescribeName) {
        // 获取模板
        ImportDescribe[] describes = ImportDescribe.getImportDescribe(templateDescribeName);
        List<T> resultList = new ArrayList<>();
        for (List<String> row : table) {
            T object = createObject(clz);
            boolean flag=true;
            for (ImportDescribe describe : describes) {
                flag=flag?accept(object,describe,row):flag;
            }
            resultList.add(object);
        }
        return resultList;
    }

    /**
     * 将List<List<Object>>转换成实体列表
     *
     * @param clz                  实体类型
     * @param table                导入数据
     * @param templateDescribeName 模板描述名称
     * @param <T>                  实体类型
     * @return 实体列表
     */
    public static <T> List<T> importObjectExcel(Class<T> clz, List<List<Object>> table, String templateDescribeName) {
        List<List<String>> stringTable = new ArrayList<>();
        table.forEach(o -> {
            List<String> line = new ArrayList<>();
            o.forEach(p -> line.add(p.toString()));
            stringTable.add(line);
        });
        stringTable.remove(0);
        System.out.println("importObjectExcel"+stringTable.size());
        return importExcel(clz, stringTable, templateDescribeName);
    }


    /**
     * 应用excel模板
     *
     * @param object   构建的对象
     * @param describe excel与实体对应关系
     * @param row      excel一行记录
     * @param <T>      实体类
     * @return excel内容是否符合约束条件
     */
    @SuppressWarnings("ConstantConditions")
    static <T> boolean accept(T object, ImportDescribe describe, List<String> row) {
        try {
            Field field = getField(object.getClass(), describe.name);
            String cell = describe.index == null ? null : row.get(describe.index);
            switch (describe.type) {
                case String:
                    field.set(object, cell);
                    break;
                case Integer:
                    field.set(object, Integer.parseInt(cell));
                    break;
                case Double:
                    field.set(object, Double.parseDouble(cell));
                    break;
                case Float:
                    field.set(object, Float.parseFloat(cell));
                    break;
                case Boolean:
                    field.set(object, Boolean.parseBoolean(cell));
                    break;
                case BigDecimal:
                    field.set(object, BigDecimal.valueOf(Long.parseLong(cell)));
                    break;
                case Date:
                    field.set(object, new SimpleDateFormat(describe.describe).parse(cell));
                    break;
                case Consumer:
                    describe.consumer.accept(row, object);
                    break;
                case NotNull:
                    if (StringUtils.isEmpty(cell)) throw new Exception("必填项为空");
                default:
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return !describe.notNull;
        }
    }

    /**
     * 根据类名创建对象
     *
     * @param clz 类名
     * @param <T> 实体类
     * @return 实体对象
     */
    static <T> T createObject(Class<T> clz) {
        try {
            return clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * excel 与 实体类对应关系
     */
    @SuppressWarnings({"SameParameterValue", "unused"})
    static class ImportDescribe {
        /**
         * 字段在Excel中的序号
         */
        public final Integer index;
        /**
         * 字段在实体中的名称
         */
        public final String name;
        /**
         * 字段类型
         */
        public final Type type;
        /**
         * 附加信息 如:时间格式
         */
        public final String describe;
        /**
         * 是否非空
         */
        public final Boolean notNull;
        /**
         * 自定义处理器
         */
        public final BiConsumer<List<String>, Object> consumer;

        /**
         * 全参数构造函数
         *
         * @param index    excel列编号
         * @param name     实体对象名称
         * @param type     数据类型
         * @param describe 附加信息
         * @param consumer 自定义处理器
         * @param notNull  是否非空
         */
        private ImportDescribe(Integer index, String name, Type type, String describe, BiConsumer<List<String>, Object> consumer, boolean notNull) {
            this.index = index;
            this.name = name;
            this.type = type;
            this.describe = describe;
            this.notNull = notNull;
            this.consumer = consumer;
        }

        static ImportDescribe createBoolean(int index, String name) {
            return new ImportDescribe(index, name, Type.Boolean, null, null, false);
        }

        static ImportDescribe createBoolean(int index, String name, Boolean notNull) {
            return new ImportDescribe(index, name, Type.Boolean, null, null, notNull);
        }

        static ImportDescribe createInteger(int index, String name) {
            return new ImportDescribe(index, name, Type.Integer, null, null, false);
        }

        static ImportDescribe createInteger(int index, String name, Boolean notNull) {
            return new ImportDescribe(index, name, Type.Integer, null, null, notNull);
        }

        static ImportDescribe createFloat(int index, String name) {
            return new ImportDescribe(index, name, Type.Float, null, null, false);
        }

        static ImportDescribe createFloat(int index, String name, Boolean notNull) {
            return new ImportDescribe(index, name, Type.Float, null, null, notNull);
        }

        static ImportDescribe createDouble(int index, String name) {
            return new ImportDescribe(index, name, Type.Double, null, null, false);
        }

        static ImportDescribe createDouble(int index, String name, Boolean notNull) {
            return new ImportDescribe(index, name, Type.Double, null, null, notNull);
        }

        static ImportDescribe createString(int index, String name) {
            return new ImportDescribe(index, name, Type.String, null, null, false);
        }

        static ImportDescribe createString(int index, String name, Boolean notNull) {
            return new ImportDescribe(index, name, Type.String, null, null, notNull);
        }

        static ImportDescribe createDate(int index, String name) {
            return new ImportDescribe(index, name, Type.Date, null, null, false);
        }

        static ImportDescribe createDate(int index, String name, Boolean notNull) {
            return new ImportDescribe(index, name, Type.Date, null, null, notNull);
        }

        static ImportDescribe createDate(int index, String name, String format) {
            return new ImportDescribe(index, name, Type.Date, format, null, false);
        }

        static ImportDescribe createDate(int index, String name, String format, Boolean notNull) {
            return new ImportDescribe(index, name, Type.Date, format, null, notNull);
        }

        static ImportDescribe createConsumer(BiConsumer<List<String>, Object> consumer) {
            return new ImportDescribe(null, null, Type.Consumer, null, consumer, false);
        }

        static ImportDescribe createBigDecimal(int index, String name) {
            return new ImportDescribe(index, name, Type.BigDecimal, null, null, false);
        }

        static ImportDescribe createNotNull(int index) {
            return new ImportDescribe(index, null, Type.NotNull, null, null, true);
        }

        static ImportDescribe createBigDecimal(int index, String name, Boolean notNull) {
            return new ImportDescribe(index, name, Type.BigDecimal, null, null, notNull);
        }

        /**
         * 根据名称获取预定义的模板
         *
         * @param templateName 模板名称
         * @return 模板
         */
        public static ImportDescribe[] getImportDescribe(String templateName) {
            return Holder.importDescribe.get(templateName);
        }

        @Override
        public String toString() {
            return "ImportDescribe{" +
                    "index=" + index +
                    ", name='" + name + '\'' +
                    ", type=" + type +
                    ", describe='" + describe + '\'' +
                    ", notNull=" + notNull +
                    ", consumer=" + consumer +
                    '}';
        }

        public enum Type {
            Boolean,
            Integer,
            Float,
            Double,
            String,
            Date,
            Consumer,
            NotNull,
            BigDecimal
        }

        /**
         * 存储预定义的模板
         */
        public static class Holder {
            static Map<String, ImportDescribe[]> importDescribe = new HashMap<>();

            static {
                ImportDescribe[] employeesCost = new ImportDescribe[9];
                employeesCost[0] = createNotNull(0);
                employeesCost[1] = createConsumer((strings, o) -> ((EmployeesCost) o).setEmployee(employeeService.selectByName(strings.get(0))));
                employeesCost[2] = createString(1, "costTime");
                employeesCost[3] = createBigDecimal(2, "salary");
                employeesCost[4] = createBigDecimal(3, "socialSecurity");
                employeesCost[5] = createBigDecimal(4, "tripSubsidies");
                employeesCost[6] = createBigDecimal(5, "lastYearCost");
                employeesCost[7] = createBigDecimal(6, "bonus");
                employeesCost[8] = createBigDecimal(7, "standardSalary");
                importDescribe.put("employeesCost", employeesCost);
            }
        }
    }
}
