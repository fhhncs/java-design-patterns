package org.design.singleton;

/**
 * @author hap
 * @version 1.0
 * @description: 饿汉模式，单例实例在类装载时进行创建(使用静态代码块来创建)，线程安全
 */
public class SingletonExample6 {
    private SingletonExample6() {}
    private static SingletonExample6 instance;
    static{
        instance = new SingletonExample6();
    }
    public static SingletonExample6 getInstance(){
        return instance;
    }
}
