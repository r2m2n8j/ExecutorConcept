package map.hashmap.linkedhashmap.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();

            for (int i = 0; i < 5; i++) {
                // Increment the value associated with the thread's name in the shared map
                concurrentHashMap.compute(threadName, (key, value) -> (value == null) ? 1 : value + 1);

                System.out.println(threadName + " - Updated map: " + concurrentHashMap);
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final map content: " + concurrentHashMap);
    }
}
