package org.design.singleton;

/**
 * @author 13346
 * @version 1.0
 * 饿汉模式，单例实例在类装载时进行创建
 * 优点：没有线程安全问题
 * 缺点：可能会浪费内存
 */
public class SingletonExample2 {

    private SingletonExample2(){}
    private static SingletonExample2 instance = new SingletonExample2();
    public static SingletonExample2 getInstance(){
        return instance;
    }

}
