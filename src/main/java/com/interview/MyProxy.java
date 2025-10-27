package com.interview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;




public class MyProxy {

    static interface MyService{
        void doSomething();
    }

    static class MyClass implements MyService{

        public MyClass(){}

        public void doSomething(){
            System.out.println("doSomething");
        }
    }

    static class ProxyClass implements InvocationHandler{

        private Object target;
        public ProxyClass(Object target){
            this.target = target;
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Proxy content");
            Object res = method.invoke(target, args);
            System.out.println("Proxy content");
            return res;
        }

    }

    public static void main(String[] args){
        MyService myService = new MyClass();
        MyService res = (MyService) Proxy.newProxyInstance(
                myService.getClass().getClassLoader(),
                myService.getClass().getInterfaces(),
                new ProxyClass(myService));
        res.doSomething();
    }


}
