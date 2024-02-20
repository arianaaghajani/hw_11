public class PrintOddEven {
    private int max;
    private int number=1;

    public PrintOddEven(int max) {
        this.max = max;
    }

//    public static void main(String[] args) {
//        PrintOddEven printer = new PrintOddEven(10);
//
//        Thread evenThread = new Thread(() -> printer.printEven());
//        Thread oddThread = new Thread(() -> printer.printOdd());
//
//        evenThread.start();
//        oddThread.start();
//    }

    public void printEven() {
        while (number <= max) {
            synchronized (this) {
                if (number % 2 == 0) {
                    System.out.println("Even: " + number);
                    number++;
                    this.notify();
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void printOdd() {
        while (number <= max) {
            synchronized (this) {
                if (number % 2 != 0) {
                    System.out.println("Odd: " + number);
                    number++;
                    this.notify();
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
