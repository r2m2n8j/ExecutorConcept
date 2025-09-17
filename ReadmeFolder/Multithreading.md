# CPU
- The cpu is a brain of the computer, is responsible for executing instructions from programs.
- It performs basic arithmetic, logic, control, and input/output operations specified by the instructions.
- Modern example - Intel Core i7 or AMD or Ryzen7

# Core
- A core is an individual processing unit within the CPU.
- Modern CPUs can have multiple cores, allowing them to perform multiple tasks simultaneously.
- 8-core CPU
    - 4 high-performance cores (called "Firestorm") → handle heavy tasks like coding, compiling, video editing.
    - 4 high-efficiency cores (called "Icestorm") → handle light tasks like browsing, background apps, notifications to save battery.
- 💡 Together, they balance performance + battery life. macOS decides which cores to use depending on workload.

# Program
- Set of instruction

# Process
- An instance of a program that is being executed.
- When a program runs, the operating system creates process to manage its execution.

# Thread
- A thread is the smallest unit of execution within a process.
- A process can have multiple threads, which share the same resources but can run independently.
- For example - In the IntelliJ I've created a .md file. Here one thread is working to write text another thread is working to checking grammar. Another thread is formating this file according to the .md format. So multiple thread is working independently at same time to make a .md file.


# Multitasking 
- Executing several task simultaneously where each task is a seperate independent program(process) is called process based multitasking.


- 1. Multitasking utilizes the capabilities of a CPU and its cores. When an operating system performs multitasking, it can assign different tasks to different cores. This is more efficient than assigning all tasks to a single core.

# Multithreading
- Multithreading refers to the ability to execute multiple threads within a single process concurrently.
- Multithreading **enhances** the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks or threads.
- These threads can be processed simultaneously, making better use of the CPU's capabilities.

##### Context switching
##### Time-slicing

- In a multicore environment, Java's multithreading can take full advantage of the available cores.
- The JVM can distribute threads across multiple cores, allowing true parallel execution of threads.
- In Java **JVM** handle all threads, and it is written inside the **java.lang package**
- java.lang.Thread or java.lang.Runnable


- When a Java program starts, one thread begins running immediately, which is called the main thread.
- This thread is responsible for executing the main method of a program.
- For example when you print a hello-world after printing the hello-world you can see **Process finished with exit code 0** It means a main thread is running a means a process is running.

#### How to create a Thread in Java?
- Follow Copy.
- How can we create a thread with extends Thread class and implements a Runnable interface.
- **How to start a Thread?**
- We have to use call **start() method** that is present inside the Thread class.

-**Extend Thread class**

            public class MyThread extends Thread{
            
                public MyThread(String name){
                    super(name);
                }
                @Override
                public void run() {
                    for(;;){
                        System.out.println(currentThread().getName() + " priority " + currentThread().getPriority());
                        System.out.println("hello run method");
                    }
                }
                public  static void main(String []args){
                    MyThread myThread = new MyThread("anuj");
                    myThread.start();
                    for(;;){
                        System.out.println("main");
                    }
                }
            }


    O/P    
        main
        main
        anuj priority 5
        hello run method
        anuj priority 5


- **implements Runnable interface**

        package com.org.executor.framework.executor;

        import static java.lang.Thread.currentThread;
        
        public class MyThread implements Runnable{
        
            public MyThread(String name){
                super();
            }
            @Override
            public void run() {
                for(;;){
                    System.out.println(currentThread().getName() + " priority " + currentThread().getPriority());
                    System.out.println("hello run method");
                }
            }
            public  static void main(String []args){
                MyThread myThread = new MyThread("anuj");
                Thread t = new Thread(myThread);
                t.start();
                for(;;){
                    System.out.println("main");
                }
            }
        }


##### Check thread methods
- Start
- run
- sleep
- join
- yield
- setPriority
- interrupt
- set Thread name  - create a constructor inside the class 
- **User thread** - Main thread and JVM is wait for it.
- **DAEMON THREAD**
- A thread that is running in the background is called Daemon thread. Like garbage collector.
- JVM is not wait for the daemon thread.

            myThread.setDaemon(true);
- It means we are setting myThread as a Daemon so JVM will not wait for it.



##### Synchronization
- Follow copy
- **synchronized** 

            public synchronized void updateStudentInDataBase(Student s){
                update code....
            }

            public void readStudentFromDataBase(){
                read code....
            }

- **synchronized** area -> when even we are performing update operation (add, remove, delete/replace) Where state of an object is changing.
- non synchronized area -> where object won't be change like read.






