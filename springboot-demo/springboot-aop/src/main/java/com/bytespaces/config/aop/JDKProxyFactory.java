package com.bytespaces.config.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyFactory implements InvocationHandler {
    //目标对象
    private Object target;

    public JDKProxyFactory(Object target) {
        this.target = target;
    }

    //使用Proxy创建代理对象
    public Object createProxy(){
        //目标类的类加载器对象
        ClassLoader classLoader = target.getClass().getClassLoader();
        //目标类的实现接口的Class[]
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //当前对象需实现InvocationHandler接口
        return Proxy.newProxyInstance(classLoader,interfaces,this);
    }

    /**
     *
     * @param proxy  代理对象，一般不用
     * @param method 方法对象
     * @param args  方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在调用目标对象方法前，统一做一些其他操作，即功能增强
        System.out.println ("例如：日志操作......");
        return method.invoke(target,args);
    }
}