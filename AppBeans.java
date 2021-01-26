
 * 框架初始化结束后接收并存储Spring Context
 * 用于在任何位置调用AppBeans.getBeans(className)获取Bean容器托管的对象实例
 *
 * @author cui
 */
@Component
public class AppBeans implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static <T> T getBeans(Class<T> t) {
        return applicationContext.getBean(t);
    }

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        AppBeans.applicationContext = applicationContext;
    }
}
