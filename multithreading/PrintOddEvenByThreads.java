package multithreading;

public class PrintOddEvenByThreads {
    public static void main(String[] args) throws InterruptedException {
        OddEvenCounter counter = OddEvenCounter.getInstance();
        Thread evenThread= new Thread(() -> {
            try {
                counter.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        evenThread.setName("EvenThread");
        Thread oddThread= new Thread(() -> {
            try {
                counter.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        oddThread.setName("OddThread");
        evenThread.start();
        oddThread.start();
        evenThread.join();
        oddThread.join();
    }
}
