package multithreading;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* This class contains an example of thread synchronization with executorService
* */
public class ThreadSynchronisationExample {
    static Counter counter= null;
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        Runnable task= () -> {
            if(counter==null){
                counter=Counter.getInstance();
            }
            System.out.println(counter.increment());
        };
        for (int i=0;i<11;i++){
            executorService.submit(task);
        }
        executorService.shutdown();
    }

}
