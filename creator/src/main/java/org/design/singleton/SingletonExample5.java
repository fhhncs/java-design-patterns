package org.design.singleton;

/**
 * @author hap
 * @version 1.0
 * 同步锁单例模式(DCL,加volatile)，线程安全的
 * 双重检查的原因：
 * 双重检查（Double-Checked Locking）的核心目的是 在“延迟加载”的同时，既保证线程安全，又把同步带来的性能损耗降到最低。
 * 具体原因如下：
 * 1.第一次检查（无锁）
 * 如果实例已经创建，绝大多数线程在这里就能直接返回，完全不需要加锁，避免了不必要的同步开销。
 * 2.第二次检查（加锁后）
 * 只有当实例尚未创建时，才进入 synchronized 块；进入后再次检查，防止 多个线程排队时重复创建 实例，确保单例的唯一性。
 * 3.减少锁竞争
 * 把锁的粒度从“每次调用都加锁”缩小到“仅在第一次创建时加锁”，高并发场景下可显著提升吞吐量。
 * 4.需要 volatile
 * 由于 instance = new SingletonExample3() 可能涉及 对象初始化和引用写入的重排序，必须用 volatile 禁止重排序，才能保证其他线程不会拿到“半初始化”的对象。
 *
 */
public class SingletonExample5 {
    private SingletonExample5() {}
    private static volatile SingletonExample5 instance = null;//禁止指令重排
    public static synchronized SingletonExample5 getInstance(){
        if(instance==null){
            synchronized (SingletonExample5.class){
                if(instance==null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }

}
