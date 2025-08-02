package org.design.singleton;

/**
 * 枚举模式，线程安全
 * 枚举方式进行实例化，是线程安全的，此种方式也是线程最安全的
 * 枚举类型是线程安全的，并且只会装载一次，设计者充分利用了枚举类型这一特性，
 * 避免了由于多个线程同时初始化一个单例导致的线程安全问题。
 * 因此，枚举模式是实现单例模式的最佳方式。
 */
public class SingletonExample7 {
    private SingletonExample7() {}
    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
    private enum Singleton{
        INSTANCE;
        private SingletonExample7 singleton;
        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }
        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
