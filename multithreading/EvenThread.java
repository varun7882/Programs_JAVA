package multithreading;

import java.util.concurrent.Semaphore;

public class EvenThread extends Thread {
    private String name;
    private int from;
    private int till;
    private Notifier notifier=null;
    public EvenThread(String name,int from,int till,Notifier notifier) {
        this.name=name;
        this.from=from%2==0?from:++from;
        this.till=till;
        this.notifier=notifier;
    }

    @Override
    public void run() {
        while (from<=till){
            System.out.println(name+" "+from);
            from=from+2;
            try {
                Thread.sleep(500);
                notifier.notifyAndWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
