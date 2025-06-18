package com.org.executor.framework.executor;

import java.util.concurrent.*;

public class ExecutorThread {
    public static void main(String[] args) {
       /*
        In the SimpleThread class we are creating thread and doing our work(find factorial)
        But we don't want to do this.
            We want Java will create thread and we only focus our own work
                like here finding factorial of all the numbers
            To OVER COME THIS PROBLEM JAVA INTRODUCE EXECUTOR IN Java 5 version
        */
        System.out.println("Concept of Executor Thread");

        createMultipleThreadAndCallFactorial();

    }
    public static void createMultipleThreadAndCallFactorial() {
        long startTime = System.currentTimeMillis();
//        Executor executor = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        Future<?> future = null;
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            // creating thread one by one and adding it into thread array
            future = executorService.submit(
                    () -> {
                        System.out.println(finalI + " = " + factorial(finalI));
                    }
            );
        }
        try {
            future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();


//        try {
//            executorService.awaitTermination(4, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time : "+ (endTime-startTime));
    }
    // 5 = 5*4*3*2*1
    public static long factorial(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int ans = 1;
        for (int i = number; i > 0; i--) {
            ans *= i;
        }
        return ans;
    }
}
