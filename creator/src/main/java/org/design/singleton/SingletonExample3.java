package org.design.singleton;

/**
 * @author hap
 * @version 1.0
 * @description: 懒汉式-线程安全,在高并发场景下会 严重降低性能，因此不推荐使用
 *
 */
public class SingletonExample3 {
    private SingletonExample3(){}
    private static SingletonExample3 instance = null;
    public static synchronized SingletonExample3 getInstance(){
        if(instance==null){
            instance=new SingletonExample3();
        }
        return instance;
    }

}
