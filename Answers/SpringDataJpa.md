# Spring Data JPA

### Dependency 

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

### What is JPA and how is it related to Spring DATA JPA?

- JPA - Means Java Persistence API 
- And it is used to manage relational Data.
- JPA usage by reducing boilerplate code - means we no need to explicitly write SQL Query.
    - Main use case of Storing the Java Object into the relational database without writing SQL.



### What are the key annotations used in JPA?
- @Entity, @Table, @Id, @GenaratedValue, @Column, @OneToOne, @ManyToOne, @OneToMany ...etc...

- @Entity
    - Marks a Java class as a JPA Entity meaning it maps to a database table.
    - @Entity tells JPA to treat the class as a database table. Each instance of this class represents a row in that table.

            @Entity
            @Table(name = "users")
            public class User { 
                
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;
                
                @Column(name = "employee_name", nullable = false)
                private String name;

                @OneToOne
                @JoinColumn(name = "address_id")
                private Address address;
                /* ... */ 
            }

- @Table
    - Specifies the name of the table in the database (optional if same as class name)


- @Id
    - Marks a field as the primary key of the entity.

- @GenaratedValue
    - Used to auto-generate primary key values (like auto-increment).
    - Common Strategies
        - AUTO – JPA chooses generation strategy automatically

        - IDENTITY – Relies on DB auto-increment

        - SEQUENCE – Uses a database sequence

        - TABLE – Uses a table to generate values


- @Column
    - Customizes the mapping between a field and its column in the table.

            @Column(name = "employee_name", nullable = false)
            private String name;

    - Common Attributes
        - name – column name
        - nullable – if null is allowed
        - length – max length for String
        - unique – if values must be unique



- @OneToOne
    - Used when one entity is associated with exactly one other entity.

                @OneToOne
                @JoinColumn(name = "address_id")
                private Address address;


- @ManyToOne
    - Used when many entities relate to one entity. (e.g., Many employees belong to one department.)

            @ManyToOne
            @JoinColumn(name = "department_id")
            private Department department;


#### ManyToOne and OneToMany

- First, Understand the Relationship with real-world analogy:

    - One Department has many Employees
    - But each Employee belongs to only one Department
- So:
    - On Employee side → @ManyToOne
    - On Department side → @OneToMany

##### Entity Structure
- Employee Entity (OWNING side)

        @Entity
        public class Employee {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            private String name;

            @ManyToOne
            @JoinColumn(name = "department_id") // Foreign key column in Employee table
            private Department department;

            // getters and setters
        }

- Department Entity (INVERSE side)

        @Entity
        public class Department {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            private String deptName;

            @OneToMany(mappedBy = "department") // 'department' is the field in Employee
            private List<Employee> employees;

            // getters and setters
        }

- @ManyToOne (on Employee side)
    - Each employee belongs to one department
    - @JoinColumn(name = "department_id") creates a foreign key in the Employee table.
    - This is the owning side of the relationship.

- In DB:
    - Employee table will have a column: department_id

- @OneToMany(mappedBy = "department") (on Department side)
    - One department can have many employees
    - mappedBy = "department" tells Hibernate:

        - “I am not the owner of the relationship. Look at the department field in the Employee entity to figure out the mapping.”

    - No extra table or foreign key is created here — this is just for reading the relationship in reverse.



            In the Database
            Department Table
            id	    dept_name
            1	    HR
            2	    Engineering

            Employee Table
            id	    name	    department_id
            1	    Anuj	        1
            2	    Bittu           1
            3	    Chaman	        2

- Anuj & Bittu -> HR (department_id = 1)
- Chaman -> Engineering (department_id = 2)


- Bi-directional vs Uni-directional
    - Bi-directional
        - When both sides are mapped: Employee → Department and Department → Employee

        - Helps in reading both ways, e.g., employee.getDepartment() and department.getEmployees()

    - Uni-directional
        - If only one side has the relationship, e.g., only Employee has @ManyToOne

        - Simpler, but less flexible. You can’t navigate from Department to Employee.


- Question

    - What is the owning side?	-> The side with the @JoinColumn, usually @ManyToOne.
    - Why use mappedBy?	-> To prevent extra join tables and define inverse mapping.
    - Can @OneToMany exist alone? -> Yes, but it will create a join table unless you use mappedBy.
    - What's the default fetch type? -> @ManyToOne = EAGER, @OneToMany = LAZY




#### @ManyToMany?
- You use @ManyToMany when multiple records in one table are related to multiple records in another table.

- Real-World Example
    - A Student can enroll in multiple Courses, and a Course can have multiple Students
- So:
    - Student ↔ Course = @ManyToMany

- Student Entity

        @Entity
        public class Student {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            private String name;

            @ManyToMany
            @JoinTable(
                name = "student_course", // join table name
                joinColumns = @JoinColumn(name = "student_id"), // owning side
                inverseJoinColumns = @JoinColumn(name = "course_id") // target side
            )
            private List<Course> courses;

            // getters and setters
        }

- Course Entity

        @Entity
        public class Course {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            private String courseName;

            @ManyToMany(mappedBy = "courses") // inverse side
            private List<Student> students;

            // getters and setters
        }


- Key Concepts
    - @JoinTable
        - This creates a linking table in the database to manage the many-to-many relationship.
        - It includes:
            - joinColumns: reference to the current entity (Student)
            - inverseJoinColumns: reference to the target entity (Course)

    - mappedBy
        - Tells Hibernate:
            - “I’m the inverse side. The relationship is managed by the courses field in the Student entity.”

- Database

    - Student Table

            id	        name
            1	        Anuj
            2	        Bittu

    - Course Table

            id	    course_name
            1	    Java
            2	    Spring Boot

    - student_course (Join Table)

            student_id	course_id
            1	            1
            1	            2
            2	            1

- Anuj enrolled in Java and Spring Boot
- Bittu enrolled in Java only


- What if you forget mappedBy?
    - Hibernate will create two join tables, one from Student → Course and another from Course → Student →  Bad design.

- When to use @ManyToMany?
    - Use only when it's truly many-to-many, like:
        - Students and Courses
        - Authors and Books
        - Users and Roles

- In real world, it's often better to convert it to two @OneToMany relationships with a separate entity (called a join entity or bridge entity).

- @ManyToMany is used when multiple records in one table relate to multiple records in another. I define the owning side with @JoinTable, and the inverse side uses mappedBy. Internally, JPA (via Hibernate) creates a third table to maintain the relationship.


### What is the purpose of JpaRepository?
- It is a Spring Data intrface that provides CRUD, pagination and custom query functionality.

- Interacting with the User entity without writing any DAO implementation.


### Difference b/w CrudRepository and JpaRepository
- JpaRepository extends CrudRepository and adds Jpa - specification features like flushing and batch operations.
- JpaRepository for advanced operations like pagination, and batch inserts.

### How do you define custom queries in Spring Data JPA?
- Using @Query annotation.








