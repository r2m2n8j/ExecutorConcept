1. Executor Interface:
 * Executor is a simple interface defined in the java.util.concurrent package.
 * It has a single method
 *     void execute(Runnable command);
 *  This method takes a Runnable task and submits it for execution.
    The Executor implementation handles the details of how and when the task will be run
    (e.g., in a new thread, in a thread pool).
 *  It does not provide any mechanisms for controlling or tracking the submitted tasks
    (e.g., getting results, canceling tasks, or shutting down the executor).

2. ExecutorService Interface:
    *   ExecutorService is a subinterface of Executor, also found in java.util.concurrent.
    *   It extends the basic functionality of Executor by adding features for managing the lifecycle of both the tasks and the executor itself.
    *   Key additions in ExecutorService include:
        *   Lifecycle Management: Methods like shutdown(), shutdownNow(), and isTerminated() allow for graceful or immediate termination of the executor and management of its state.
        *   Task Tracking and Control: The submit() methods (which can take Runnable or Callable tasks) return a Future object. This Future can be used to:
            *   Retrieve the result of a Callable task.
            *   Check if a task has completed.
            *   Cancel a running or pending task.
        *   Bulk Task Execution: Methods like invokeAny() and invokeAll() enable executing collections of tasks and waiting for their completion or the completion of the first successful task.



