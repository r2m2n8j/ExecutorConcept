package com.org.executor.framework.executor;

import java.sql.Time;
import java.util.concurrent.*;

public class ScheduledExecutorServiceConcept {
    public static void main(String[] args) {
//        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        /*scheduler.schedule(
                ()-> System.out.println("A runnable command wait for 2 seconds delay"),
                2,
                TimeUnit.SECONDS
        );*/
        ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(
                () -> System.out.println("Execute every 2 seconds"),
                2,
                2,
                TimeUnit.SECONDS
        );
        ScheduledFuture<?> shutDown = scheduler.schedule(
                () -> {
                    System.out.println("ShutDown");
                    scheduler.shutdown();
                },
                5,
                TimeUnit.SECONDS
        );

    }
}
