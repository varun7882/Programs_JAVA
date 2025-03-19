package multithreading;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PrimeNumbers {
    public static void main(String[] args) {
        Count count = new Count();
        System.out.println(count.getPrimeNumberCountTill(100000000));
        try {
            System.out.println(count.getPrimeNumberCountUsingThreadsTill(100000000,100000));
            System.out.println(count.getPrimeNumberCountUsingThreadsFairlyTill(100000000));
        } catch (Exception e) {
            System.out.println("Something went wrong in threaded method "+e.getMessage());
        }
    }
}
class Count {
    public static AtomicInteger primeCount = new AtomicInteger(1);
    public static AtomicInteger num = new AtomicInteger(2);
    ExecutorService executorService;
    public Count () {
        executorService = Executors.newFixedThreadPool(10);
    }
    public long getPrimeNumberCountTill(long x) {
        Instant start = Instant.now();
        long countPrime = 1;
        for (long i=3;i<=x;i++) {
            if(isPrime(i)) {
                countPrime++;
            }
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Prime number counted in seconds: " + duration.getSeconds());
        return countPrime;
    }
    public long getPrimeNumberCountUsingThreadsTill(long x, long batchSize) throws ExecutionException, InterruptedException {
        Instant start = Instant.now();
        long countPrime = 1;
        long numOfBatches = x / batchSize;
        List<Future<Long>> results = new ArrayList<>();
        results.add(executorService.submit(new CountPrimeTask(3, batchSize,0)));
        for(int i=1;i<numOfBatches;i++) {
            results.add(executorService.submit(new CountPrimeTask(i*batchSize + 1, Math.min((i+1)*batchSize,x), i)));
        }

        for(int i=0;i<results.size();i++){
            countPrime += results.get(i).get();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Prime number counted using threads in seconds: " + duration.getSeconds());
        return countPrime;
    }

    public long getPrimeNumberCountUsingThreadsFairlyTill(long x) throws ExecutionException, InterruptedException {
        Instant start = Instant.now();
        int taskCount = 10;
        CountDownLatch latch = new CountDownLatch(taskCount);
        for(int i=0;i<taskCount;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try{
                    while (true) {
                        int currNum = num.incrementAndGet();
                        if(currNum>x) break;
                        if (isPrime((long)currNum)) {
                            primeCount.incrementAndGet();
                        }
                    }
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        latch.await();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Prime number counted using threads fairly in seconds: " + duration.getSeconds());
        return primeCount.get();
    }
    private boolean isPrime(Long x) {
        if(x==1) return false;
        if(x==2) return true;
        for(long i=2;i<=(long)Math.sqrt(x);i++) {
            if(x % i ==0) return false;
        }
        return true;
    }
    class CountPrimeTask implements Callable<Long> {

        long start,end;
        int threadName;
        public CountPrimeTask(long s,long e, int name) {
            start = s;
            end = e;
            threadName = name;
        }
        @Override
        public Long call() throws Exception {
            Instant startTime = Instant.now();
            long countPrime = 0;
            for (long i=start;i<=end;i++) {
                if(isPrime(i)) {
                    countPrime++;
                }
            }
            Instant endTime = Instant.now();
            Duration duration = Duration.between(startTime, endTime);
        //    System.out.println("Prime number counted by thread "+threadName +" in " + duration.getSeconds()+" seconds");
            return countPrime;
        }
    }
}
