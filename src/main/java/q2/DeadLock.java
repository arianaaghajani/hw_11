package q2;

public class DeadLock {
    static Object lock1 = new Object();
    static Object lock2 = new Object();



    private static class MyThread1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("thread 1 :  holding lock 1 ...");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread 1 : waiting for lock 2...");

                synchronized (lock2) {
                    System.out.println("thread 1; holding lock 1 and lock 2");
                }
            }
        }
    }
    private static class MyThread2 implements Runnable{

        @Override
        public void run() {
            synchronized (lock2){
                System.out.println("thread 2 : holding lock 2 ...");

                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("thread 2 : waiting for lock 1 ...");

                synchronized (lock1){
                    System.out.println("thread 2: holding lock 2 and lock 1");
                }
            }
        }
    }
}

