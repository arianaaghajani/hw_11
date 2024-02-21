package q3;

import java.util.concurrent.locks.ReentrantLock;

public class Starvation {
    static ReentrantLock lock =new ReentrantLock(true);


    static class Worker implements Runnable {
        @Override
        public void run() {
            while (true){
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " the lock");
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
