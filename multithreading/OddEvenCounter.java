package multithreading;

public class OddEvenCounter {
    private static OddEvenCounter instance=null;
    private int counter;
    private  OddEvenCounter(){
        counter=0;
    }
    public  static  OddEvenCounter getInstance(){
        if(instance==null){
            instance= new OddEvenCounter();
        }
        return instance;
    }
    public void increment() throws InterruptedException {
        synchronized (this) {
            while (counter<=50){
            System.out.println(Thread.currentThread().getName()+" : "+counter);
            Thread.sleep(500);
            counter++;
            notify();
            wait();
            }
            notifyAll();
        }
    }
    public int getCount(){
        return counter;
    }
}
