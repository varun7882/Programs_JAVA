package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemoryInconsistencyExample {
     static volatile Boolean sayHello=false;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Runnable task= new Runnable() {
            @Override
            public void run() {
                while (!sayHello){
                    //busy waiting
                }
                System.out.println("Hellllooooo!!!!");
                while (sayHello){
                    //busy waiting
                }
                System.out.println("Byeeeeee!!!!");
            }
        };
        executorService.submit(task);
        System.out.println("say hello");
        sayHello=true;
        Thread.sleep(2000L);
        System.out.println("say bye");
        sayHello=false;
        Thread.sleep(2000L);
        executorService.shutdown();
    }
}
