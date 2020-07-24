package com.mashibing.dp.proxy.v11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *  动态代理演示
 *  通过分析代码可以看出Java 动态代理，具体有如下四步骤：
 通过实现 InvocationHandler 接口创建自己的调用处理器；
 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
 */
public class Test{
    public static void main(String[] args) {
        //代理的真实对象
        Subject realSubject = new RealSubject();
        InvocationHandler handler = new LogInterceptor(realSubject);
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();
        /**
         * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
         */
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
        subjectProxy.save();
    }
}