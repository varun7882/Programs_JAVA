package multithreading;

import java.util.concurrent.Semaphore;

public class OddEvenPrintByThreads {

    public static void main(String[] args) throws InterruptedException {
        Notifier notifier=Notifier.getInstance();
        Thread evenThread= new EvenThread("evenThread",0,10,notifier);
        Thread oddThread= new OddThread("oddThread",0,10,notifier);
        evenThread.start();
        oddThread.start();
        evenThread.join();
        oddThread.join();;
    }
}
