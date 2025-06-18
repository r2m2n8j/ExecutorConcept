package com.org.executor.framework.executor;

import javax.swing.plaf.TableHeaderUI;

public class SimpleThread {
    public static void main(String[] args) {
        System.out.println("Simple thread");
        long currentTime = System.currentTimeMillis();
        //simpleFactorialCall();
        createMultipleThreadAndCallFactorial();
        long finalTime = System.currentTimeMillis();
        System.out.println("Total Time :: " + (finalTime - currentTime));
    }

    // Creating Multiple of threads for creating factorial of 1 to 10 numbers
    public static void createMultipleThreadAndCallFactorial() {
        // Here I'm creating an array of Thread because I want to wait until all the task not completed.

        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            // creating thread one by one and adding it into thread array
            threads[i - 1] = new Thread(
                    () -> {
                        System.out.println(finalI + " = " + factorial(finalI));
                    }
            );
            threads[i - 1].start();
        }
        // Here we are waiting until all threading is complete, after that we are executing in next line.
        // And now we are getting accurate time for completing factorial
        // Total Time :: 1038
        // Earlier we are getting  Total Time :: 4
        // Because main thread was not waiting for the above thread.
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Simple calling factorial method and create factorial of 1 to 10 numbers
    public static void simpleFactorialCall() {
        for (int i = 1; i < 10; i++) {
            System.out.println(factorial(i));
        }
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
