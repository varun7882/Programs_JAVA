package multithreading;

public class Notifier {
    private static Notifier instance=null;
    private  Notifier(){
    }
    public  static  Notifier getInstance(){
        if(instance==null){
            instance= new Notifier();
        }
        return instance;
    }
    public void notifyAndWait() throws InterruptedException {
        synchronized (this) {
           notify();
           wait();
        }
    }
}
