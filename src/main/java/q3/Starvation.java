package q3;

import java.util.concurrent.locks.ReentrantLock;

public class Starvation {
    static ReentrantLock lock =new ReentrantLock(true);

    public static void main(String[] args) {
        for (int i = 0; i <= 5 ; i++) {
            Thread thread= new Thread(new Worker(),"thread" + i);
            thread.start();
        }
    }


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
