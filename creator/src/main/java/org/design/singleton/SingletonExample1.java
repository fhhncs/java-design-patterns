package org.design.singleton;

import java.lang.classfile.Signature;

/**
 * @author hap
 * @version 1.0
 * 懒汉模式，单例实例在第一次使用时进行创建   线程不安全
 * 优点：第一次使用时创建，避免内存浪费
 * 缺点：线程不安全，可能会创建多个实例
 */
public class SingletonExample1 {
    //懒汉模式
    private SingletonExample1(){}

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }

}
