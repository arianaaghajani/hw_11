public class PrintOddEven {
    private int max;
    private int number=1;

    public PrintOddEven(int max) {
        this.max = max;
    }

    public static void main(String[] args) {

    }

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
}
