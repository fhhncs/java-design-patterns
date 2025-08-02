package org.design.singleton;

/**
 * @author hap
 * @version 1.0
 * @description: 懒汉式-双重锁同步锁单例模式(DCL,没有给instance加volatile)，不是线程安全的
 * 由于存在指令重排，可能会导致线程安全问题
 * 解决方法：在instance前加上volatile关键字，禁止指令重排
 * 但是，volatile关键字也不是万能的，它只能保证可见性，不能保证原子性
 * 因此，在高并发场景下，仍然会出现线程安全问题
 * 因此，不推荐使用
 */
public class SingletonExample4 {
    private SingletonExample4(){}
    private static SingletonExample4 instance = null;
    public static SingletonExample4 getInstance(){
        if(instance==null){
            synchronized (SingletonExample4.class){
                if(instance==null){
                    instance=new SingletonExample4();
                }
            }
        }
        return instance;
    }

}
