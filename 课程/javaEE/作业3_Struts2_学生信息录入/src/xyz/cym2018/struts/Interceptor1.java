package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor1 extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Action1 action1= (Action1) actionInvocation.getAction();
        // 执行的操作.
        if(action1.getName().equals("hello"))
            return Action1.ERROR;
        return actionInvocation.invoke();
    }
}
