public class Main {
    public static void main(String[] args) {
        ///1
        PrintOddEven printer = new PrintOddEven(10);

        Thread evenThread = new Thread(() -> printer.printEven());
        Thread oddThread = new Thread(() -> printer.printOdd());

        evenThread.start();
        oddThread.start();
    }
}
