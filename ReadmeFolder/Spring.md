# What is IoC Controller and Dependency Injection
- In the typical web application 
- Client want data and that data may store in SQL/ NoSQL database.
- So we need to send the data from database to client And in Java We use **Servlet**.
- So In Spring We normally create multiple layers To fetch the data from the data base and send it to the client.
  1. Controller layer
  2. Service layer
  3. Repository layer
- In Java, Every thing is object.
- If we want to work with service in the controller than we have to create a **Service object** inside the controller.

        
    class Controller{
        Service service; this is the reference of service
    }
    

        
    class Service {
        Repository repository; this is the reference of repository
    }
    
    
- So If we want to create object that litirally we have to create using new keywords. 
- So If we have n number of classes that we have to create object of each class with the new keyword.


- So if we create an object with own (using new keyword) we as a developer have to manage entire cycle of it.
- Like Managing object Destroying object


- So As a developer We only think about logic and let someone else take care of these. Is the Concept of **IoC**.
- So **Inversion of Control** is Just a principle.
- But we need a certain technique to do it. And that's the concept of **Dependency Injection**
- So DI is actual implementation of IoC.
- **IoC** is a principle and **DI** is a Design pattern.


- The **IoC** container creates the object, wires them together, configures them and manages their complete life cycle.
- The Spring container makes use of **Dependency Injection** to manage the components that make up an application. 
- The container receives instructions for which objects to instantiate, configure, and assemble by reading the configuration metadata provided. 
- This metadata can be provided either by **XML, Java annotations or Java code**.


- In **Dependency Injection**, We do not have to create our objects but have to describe how they should be created. 
- We don’t connect our **components and services** together in the code directly, but describe which **services** are needed by which **components** in the configuration file. 
- The **IoC** container will wire them up together.



# In how many ways can Dependency Injection be done
- Constructor Injection
- Setter Injection
- Field Injection (@Autowired) loose coupling

- **Constructor Injection**
        
      public class Engine {
          public String start() {
              return "Engine started";
          }
      }

      // Car.java
      public class Car {
          private Engine engine;

          // Constructor Injection
          public Car(Engine engine) {
              this.engine = engine;
          }

          public void drive() {
              System.out.println(engine.start() + " — Car is moving");
          }
      }

- Without Spring:
- We create both objects and wire them manually.

        
    public class Main {
        public static void main(String[] args) {
            Engine engine = new Engine();       // You create it
            Car car = new Car(engine);          // You inject it manually
            car.drive();
        }
    }


- With Spring (IoC Container):
- We define beans in configuration, Spring creates and injects dependencies automatically.

**XML Config (Old style, just for illustration)**

    <bean id="engine" class="Engine"/>
    <bean id="car" class="Car">
        <constructor-arg ref="engine"/>
    </bean>

- Java Config (Modern way)
    

     @Configuration
    public class AppConfig {

        @Bean
        public Engine engine() {
            return new Engine();
        }

        @Bean
        public Car car() {
            return new Car(engine());  // Spring injects Engine into Car
        }
    }



- **Setter Injection**
    
1. Engine.java

        public class Engine {
            public String start() {
                return "Engine started";
            }
        }
2. Car.java with Setter Injection
   
    
    public class Car {
       private Engine engine;
    
       // Setter method for injection
       public void setEngine(Engine engine) {
        this.engine = engine;
       }
    
       public void drive() {
        System.out.println(engine.start() + " — Car is moving");
       }
    }
   3. Java-based Spring Configuration (AppConfig.java)

      
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Configuration
       public class AppConfig {

           @Bean
           public Engine engine() {
               return new Engine();
           }
    
           @Bean
           public Car car() {
               Car car = new Car();
               car.setEngine(engine()); // Setter Injection
               return car;
           }
       }
4. Main.java — to run the application
   
       import org.springframework.context.ApplicationContext;
       import org.springframework.context.annotation.AnnotationConfigApplicationContext;
    
        public class Main {
            public static void main(String[] args) {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                Car car = context.getBean(Car.class);
                car.drive(); // Output: Engine started — Car is moving
            }
        }



- **Field Injection**
    
    
Step 1: Your Bean Classes
    
    @Component
    public class Engine {
        public String start() {
        return "Engine started";
        }
    }

    @Component
    public class Car {
        @Autowired
        private Engine engine;
        
        public void drive() {
            System.out.println(engine.start() + " — Car is moving");
        }
    }
🔹 Step 2: Java Configuration File (Required for component scanning)
    
    @Configuration
    @ComponentScan(basePackages = "com.example") // tells Spring where to look
    public class AppConfig {}
🔹 Step 3: Main Application

    public class Main {
        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            Car car = context.getBean(Car.class);
            car.drive();  // Output: Engine started — Car is moving
        }
    }


Example in Spring Boot (Even Less Setup)
With Spring Boot:
    
    @SpringBootApplication
    public class MyApp {
        public static void main(String[] args) {
            ApplicationContext context = SpringApplication.run(MyApp.class, args);
            Car car = context.getBean(Car.class);
            car.drive();
        }
    }



- **Explanation:**
- When using field injection with annotations like @Component and @Autowired, Spring auto-wires the dependencies, but it still needs to scan the classes and manage the beans.

- This scanning and bean management is done via:

1. Java Config class with @ComponentScan
OR

2. Spring Boot’s @SpringBootApplication (which includes component scanning)
OR

3. XML config (old style)







