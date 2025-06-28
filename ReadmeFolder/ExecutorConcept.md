# Executor Interface:
- Executor is a simple interface defined in the java.util.concurrent package.
- It has a single method
- void execute(Runnable command);
- This method takes a Runnable task and submits it for execution.
The Executor implementation handles the details of how and when the task will be run
(e.g., in a new thread, in a thread pool).
- It does not provide any mechanisms for controlling or tracking the submitted tasks
(e.g., getting results, canceling tasks, or shutting down the executor).

# ExecutorService Interface:
-   ExecutorService is a subinterface of Executor, also found in java.util.concurrent.
-   It extends the basic functionality of Executor by adding features for managing the lifecycle of both the tasks and the executor itself.
-   Key additions in ExecutorService include:
-   Lifecycle Management: Methods like shutdown(), shutdownNow(), and isTerminated() allow for graceful or immediate termination of the executor and management of its state.
-   Task Tracking and Control: The submit() methods (which can take Runnable or Callable tasks) return a Future object. This Future can be used to:
*   Retrieve the result of a Callable task.
*   Check if a task has completed.
*   Cancel a running or pending task.
-   Bulk Task Execution: Methods like invokeAny() and invokeAll() enable executing collections of tasks and waiting for their completion or the completion of the first successful task.


    Executor executor = Executors.newSingleThreadExecutor();
    ExecutorService executorService = Executors.newFixedThreadPool(9);
    Future<?> runnableType = executorService.submit(() -> System.out.println("It take Runnable interface"));
    Future<String> callableType = executorService.submit(() -> "IT take Callable and return result");
    Future<String> taskResultForFuture = executorService.submit(() -> System.out.println("Executes the given tasks, returning a list of Futures holding their status and results when all complete"), "task result for Future");


# Discuss Two Small Concept of Runnable and Callable

**Runnable and Callable** interfaces are used to define tasks that can be executed by threads.
But they differ in their ability to return results and handle exceptions.
Runnable **run()** method does not return a value and cannot **throw checked exceptions**.
while Callable's **call()** method can return a value and **throw checked exceptions**.

Runnable:
Purpose: Represents a task that does not return any result and cannot throw checked exceptions.
Method: run().
Example: .

    Runnable r = () -> System.out.println("Running a task");
    @FunctionalInterface
    public interface Runnable {
        /**
         * Runs this operation.
         */
        void run();
    }

Callable:
Purpose: Represents a task that can return a result and throw checked exceptions.
Method: call().
Generic: It's a generic interface with a type parameter for the return value (e.g., Callable<Integer>).

    @FunctionalInterface
    public interface Callable<V> {
        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        V call() throws Exception;
    }


# ScheduledExecutorService
The **ScheduledExecutorService** in Java allows for scheduling tasks to run after a given delay or periodically.

    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

**Executors.newSingleThreadScheduledExecutor():**

- This creates a ScheduledExecutorService that uses a single thread to execute scheduled tasks. You can also use Executors.newScheduledThreadPool(int corePoolSize) for a pool of threads.

**scheduler.schedule(Runnable command, long delay, TimeUnit unit):**

- Schedules a one-time task (Runnable or Callable) to be executed after the specified delay.

**scheduler.scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit):**

- Schedules a periodic task. It executes the task after an initialDelay, and then repeatedly every period units of time. The period is measured from the start of the previous execution. If a task takes longer to execute than its period, the next execution will start immediately after the current one finishes.

**scheduler.scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit):**

- Schedules a periodic task similar to scheduleAtFixedRate, but the delay is measured from the end of the previous execution to the start of the next. This ensures a minimum fixed delay between task executions.

**scheduler.shutdown():**

- This method initiates a graceful shutdown of the scheduler, meaning it will stop accepting new tasks but will complete any currently running or pending tasks before terminating. It's crucial to call shutdown() to release resources and allow the program to exit.


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

# ScheduledFuture


# Future

Future represents the result of an asynchronous computation.
It is part of the **java.util.concurrent** package and was introduced in Java 5.

Asynchronous Computation Reference:
- When a task (typically a Callable) is submitted to an ExecutorService for execution,
the **submit()** method returns a Future object.
- This Future acts as a placeholder or a handle to the result of that task,
which will become available at some point in the future.
Checking Completion Status:
- Future provides methods like **isDone()** to check if the asynchronous computation has completed,
and **isCancelled()** to determine if the task was cancelled before completion.
Retrieving the Result:
- The **get()** method is used to retrieve the result of the asynchronous computation.
If the computation is not yet complete, get() will block the calling thread until the result is available.
There's also an overloaded version of get() that allows specifying a timeout, preventing indefinite blocking.
- Cancellation:
The **cancel()** method allows attempting to cancel the associated task.
Whether the cancellation is successful depends on the task's state (e.g., if it has already completed or started).



# Cached Thread Pool

Executors.newCachedThreadPool() in Java creates an ExecutorService that manages a thread pool. This type of thread pool is characterized by its dynamic nature, adapting the number of threads based on the workload.

**Dynamic Thread Creation:**
- It creates new threads as needed when a task is submitted and no idle threads are available.

**Thread Reuse:**
- It reuses previously created threads that are available in the pool, reducing the overhead of creating new threads for each task.

**Automatic Thread Removal:**
- Threads that remain idle for a specified period (defaulting to 60 seconds) are terminated and removed from the pool to conserve system resources.

**newCachedThreadPool()** is a good choice when:
- The number of tasks is highly variable and unpredictable.
- Tasks are generally short-lived.
- You want to avoid resource exhaustion from too many threads being created and never cleaned up.




