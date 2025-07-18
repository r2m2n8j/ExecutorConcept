
### When to use which type of dependency injection?
- Constructor Injection : Use for mandatory dependencies and should be provided at object creation time. It is most popular.
- Setter Injection : Use for optional dependencies or when dependencies can change after object creation, allowing flexibility in re-injecting dependencies.
- Field Injection : Generally, avoid due to limitations in testability and visibility of dependencies.

        @Autowired
        private UserService userService;
- Method Injection : Use for injecting dependencies dynamically or conditionally, providing more flexibility compared to constructor or setter injection.



# Spring: Components, Beans, Configuration & Annotation



    package loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring;
    
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;
    
    public class App {
        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            UserManager userManager = context.getBean(UserManager.class);
            userManager.getUserInfo();
        }
    }
    
    package loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring;
    
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;
    
    
    @ComponentScan(basePackages = "loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring")
    @Configuration
    public class AppConfig {
    
    }
    
    package loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring;
    
    public interface UserDataProvider {
        String getUserDetails();
    }
    
    package loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring;
    
    import org.springframework.stereotype.Component;
    
    @Component
    public class UserDatabase implements UserDataProvider {
    
        @Override
        public String getUserDetails() {
            return "User Details from MySQL Database";
        }
    }
    
    package loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring;
    
    import org.springframework.stereotype.Component;
    
    @Component
    public class WebDatabase implements UserDataProvider {
        @Override
        public String getUserDetails() {
            return "User Details from Web Database";
        }
    }
    package loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;
    
    @Component
    public class UserManager {
    UserDataProvider userDataProvider;
    
        @Autowired
        public UserManager(@Qualifier("webDatabase") UserDataProvider userDataProvider){
            this.userDataProvider = userDataProvider;
        }
        public String getUserInfo(){
            return userDataProvider.getUserDetails();
        }
    }



### What is the role of Component and @Component annotation in Spring?
- The @Component annotation is used to indicate that a class is a Spring-managed component.
- In Spring, A Component refers to a class or bean that is managed by the Spring IoC.

### What are Bean & @Bean annotation? Difference between Bean & Component?
- In Simple Bean is an Object.
- A Spring bean is an object that is instantiated, configured, and managed by the Spring IoC container. These beans are the building blocks of a Spring application.
- **@Bean** annotation in Spring is used to indicate that a method is a Bean method, and it produces or returns a bean to be managed by the spring container.

- Every component in Spring is a bean but every bean is not a component.

### What is the life cycle of a Bean in Spring?
1. Spring IoC Container (context) started

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
2. Bean instantiated

            UserManager userManager = context.getBean(UserManager.class);
    - In the above line 3 things happened.
    - Bean is retrieved from the context
3. UserDataProvider is injected via constructor.
4. Bean is ready for use.
5. Bean is used calling for the function as per the requirement.
6. Bean are destroyed automatically When is try block is closed.


### What is AppConfig, @Configuration and @CompenentScan
- **AppConfig** is a Spring configuration class that defines beans.
- **@Configuration** is an annotation in the Spring used to indicate that the class declares one or more bean methods.
- **@ComponentScan** is an annotation used to indicate that Spring will automatically scan and register beans from the specified package ("loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring")


### What is Spring IoC container? What is AnnotationConfigApplicationContext?
- The Spring IoC container (context) is responsible for managing beans based on the configuration provided in AppConfig.java
- AnnotationConfigApplicationContext is the inbuilt class provided by Spring framework for creating IoC container (context);

### What is the role of @Autowired annotation?
- **@Autowired** automatically injects dependencies into Spring-managed beans, eliminating the need for manual instantiation.

        No need to create object in manual way
        UserDatabase userDatabase = new UserDatabase();

- **When is @Autowired executed?**
    - Spring processes @Autowired after scanning all beans. 
    - It tries to resolve and inject dependencies before your class is ready for use.
- **How does Spring know what to inject?**
    - **By Type** - Spring looks for a bean of the matching type (UserDataProvider)
    - If multiple beans of same type exist, use
    - **@Qualifier("beanName")** to specify the exact one.




# Scopes of Bean 

### What is Scope of a bean? What is the default scope of a bean?

    @ComponentScan(basePackages = "loose.coupling.dataprovidier.example.with.spring.autowired.annotation.spring")
    @Configuration
    @Scope("singleton")
    public class AppConfig {
        // We can create 
        @Bean
        public Student scienceStudent(){
            return new ScienceStudent();
        }
    }

- **The Scope** of a bean in Spring refers to the lifecycle and visibility of bean instances. For example, How many instances of a bean are created and managed by the Spring IoC container.
- **Singleton** is the default scope of a bean.


### What are the different types of Spring bean scopes? What is @Scope annotation?
- We have 5 types of scope.

1. Singleton @Scope("Singleton")
2. Prototype @Scope("prototype")
3. Request @Scope("request")
4. Session @Scope("session")
5. Application @Scope("application")


### What is Singleton Scope?
- **@Scope("singleton")** : When a bean is configured to have a Singleton scope, Spring IoC container will create exactly one instance of the bean and will reuse this same instance every time the bean is requested (or injected) throughout the lifetime of the application.

### Prototype Scope
- **@Scope("prototype")** : A new bean instance is created every time it is requested.
- **Use When:** You want a fresh instance each time (e.g., for temporary tasks or per-thread logic).


### Request Scope (Web Only)
- **@Scope("request")** : A new bean is created for each HTTP request. Valid only in web applications.
- **Use When: ** You want to store data related to a single web request, like request parameters or temp session data.
- Each time a new HTTP request hits the controller, a new instance is created.


### Session Scope (Web Only)
- **@Scope("session")** : A bean instance is created per user session and shared across requests from the same session.
- **Use When:** You want to store user session-level data, like login details, cart info, etc.


### Application Scope (Web Only)
- **@Scope("application") :** A single bean shared across the entire servlet context (application) — survives until server shutdown.
- **Use When:** You want a bean shared across all users and sessions in the application.


        Quick Comparison Table
        Scope	            Context	            Lifespan	                New Instance On
        singleton	        Default         	Application lifetime	    Never (1 instance)
        prototype	        All	New every       request to getBean()	    Every request
        request	            Web app only	    Single HTTP request	        Every HTTP request
        session	            Web app only	    User session	            Every new session
        application	        Web app only	    Servlet context	            One per app lifecycle







### What is Spring AOP(Aspect oriented programming)?
- **WHY Spring AOP?**
  - In a typical application, some logic is repeated across many parts of the codebase:
      - Logging
      - Security checks
      - Transactions
      - Performance monitoring
      - Exception handling

  - These are called **cross-cutting concerns** — because they “cut across” multiple layers of your app (controller, service, DAO).

- **WHAT is Spring AOP?**
  - Spring AOP allows you to separate cross-cutting concerns from your core business logic by writing them in one place (called an aspect) and letting Spring automatically apply them behind the scenes.
  - Like Login, Security, load balancing,....




# Spring boot

### What is Spring Boot? How does it differ from the traditional Spring Framework?

- Spring Framework + Embedded Server + Auto Configuration + Starter templates = Spring Boot
- **Spring Boot is an **open-source** framework that is built on top of the Spring framework.
- **Spring boot** allows developers to quickly create **stand-alone, Production ready** Spring applications with minimal setup and configuration. 



### How Spring Boot provides autoconfiguration?
- Spring Boot provides autoconfiguration by automatically configuring Spring applications based on the dependencies present on the classpath, reducing the need of manual configuration and allowing developers to focus on writing business logic.

        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>




### What is the role of @SpringBootApplication annotation?
- When we run our spring boot application Spring boot first run the main method.
- And Here It find the @SpringBootApplication annotation.
- So @SpringBootApplication is first Bootstraps(setting up the application) the application.
- A single @SpringBootApplication annotation can be used to enable these three features, that is:
1. @Configuration : It uses @Configuration annotation and mark this class as a source of Spring been definitions.
2. @ComponentScan : It uses @ComponentScan annotation and scan the package(com.org.example) and find all the Spring component.
3. @EnableAutoConfiguration : IT uses @EnableAutoConfiguration and automatically configure all the Spring Component that are scan previously.

           import org.springframework.boot.SpringApplication;
           import org.springframework.boot.autoconfigure.SpringBootApplication;
        
           @SpringBootApplication
           public class SbEcomApplication {
             public static void main(String[] args) {
               SpringApplication.run(SbEcomApplication.class, args);
             }
           }
    
### What is the package of all Annotation?


### Difference between @Controller and @RestController
- @Controller : is a general purpose annotation used to define a controller that handles web requests. It is typically used in web applications where the response is HTML, JSP, or other types of views.
- @ResController : is a specialized version of @Controller annotation which is used to create RESTful web services where the response is typically in JSON or XML format. but it does not return views.
- @RestController : is the combination of @Controller and @ResponseBody
### Difference between @RequestParams, @RequestBody and @PathVariable
- These are used to extract values from HTTP requests in REST APIs.
1. @RequestParam
   - Purpose:
   - Used to extract query parameters from the URL.

          @GetMapping("/public/products")
           public ResponseEntity<ProductResponse> getAllProducts(
           @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
           @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
           @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_PRODUCTS_BY, required = false) String sortBy,
           @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder
           ){
           ProductResponse productResponse = productService.getAllProducts(pageNumber, pageSize, sortBy, sortOrder);
              return new ResponseEntity<>(productResponse, HttpStatus.OK);
           }

2. @PathVariable
   - Purpose:
   - Used to extract values from the URI path itself.


          @PutMapping("/api/admin/categories/{categoryId}")
          public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId){
      
            CategoryDTO savedCategoryDto = categoryService.updateCategory(categoryDTO, categoryId);
              return new ResponseEntity<>(savedCategoryDto, HttpStatus.OK);
          }


3. @RequestBody
   - Purpose:
   - Used to bind the entire HTTP request body to a Java object.
   - Typically used for POST, PUT, PATCH requests with JSON payloads.

  - See above example based on below CategoryDTO

            class CategoryDTO{
                // Variables
                // constructor
                // Setter getter
                // Methods....
            }
  -  @RequestBody maps the JSON body to the CategoryDTO object automatically.
    



















