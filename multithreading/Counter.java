package multithreading;

public class Counter {
    private static Counter instance=null;
    private int counter;
    private  Counter(){
        counter=0;
    }
    public  static  Counter getInstance(){
        if(instance==null){
            instance= new Counter();
        }
        return instance;
    }
    public int increment(){
        synchronized (this) {
            counter++;
            return counter;
        }
    }
    public int getCount(){
        return counter;
    }
}
