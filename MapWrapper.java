/**
 * 封装Map<String,Object>,根据调用的函数自动进行空值校验&类型转换
 *
 * @author cui
 */
public class MapWrapper {
    private final Map<String, Object> map;

    private MapWrapper(Map<String, Object> map) {
        this.map = map;
    }

    public static MapWrapper wrapper(Map<String, Object> map) {
        return new MapWrapper(map);
    }

    private Object getObject(String key) {
        return map.getOrDefault(key, null);
    }

    private String getValue(String key) throws NullPointerException {
        Object object = map.getOrDefault(key, null);
        if (object == null || StringUtils.isNullOrEmpty(object.toString())) {
            throw new NullPointerException();
        }
        return object.toString();
    }

    public String getString(String key) {
        try {
            return getValue(key);
        } catch (Exception e) {
            return null;
        }
    }

    public String getString(String key, String defaultValue) {
        try {
            return getString(key);
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

    public String getSubString(String key, Integer length) throws NullPointerException {
        return getString(key).substring(0, length);
    }

    public Integer getInt(String key) throws NumberFormatException {
        try {
            return Integer.parseInt(Objects.requireNonNull(getValue(key)));
        } catch (NumberFormatException | NullPointerException ignored) {
            throw new NumberFormatException();
        }
    }

    public Integer getInt(String key, Integer defaultValue) {
        try {
            return getInt(key);
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

    public List<String> getStrings(String key) {
        Object object = getObject(key);
        if (!(object instanceof List)) {
            return new ArrayList<>();
        }
        List<?> objectList = (List<?>) object;
        List<String> strings = new ArrayList<>();
        for (Object o : objectList) {
            strings.add(o.toString());
        }
        return strings;
    }

    public BigDecimal getBigDecimal(String key) throws NumberFormatException {
        String value = getValue(key);
        try {
            return BigDecimal.valueOf(Long.parseLong(Objects.requireNonNull(value)));
        } catch (NullPointerException | NumberFormatException ignored) {
            throw new NumberFormatException();
        }
    }

    public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
        try {
            return getBigDecimal(key);
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

    public Date getDate(String key) throws ParseException {
        String str = getString(key);
        return new SimpleDateFormat("yyyy-MM").parse(str);
    }

    public Date getDate(String key, Date defaultValue) {
        try {
            return getDate(key);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public Date getDate(String key, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(getString(key));
    }

    public Date getDate(String key, String pattern, Date defaultValue) {
        try {
            return getDate(key, pattern);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public Boolean notNull(String... keys) {
        for (String key : keys) {
            if (getString(key) == null) {
                return false;
            }
        }
        return true;
    }
}
