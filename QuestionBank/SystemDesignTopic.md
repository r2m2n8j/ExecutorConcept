# System design Guide

- In HLD we are designing a large system but in LLD comparatively we are designing a small system with some functionality because we have to write code (Not end to end code)

### HLD
1. Fundamentals
    - Serverless vs Serverfull
    - Horizontal vs Vertical Scaling
    - What are threads?
    - How does the internet work?

2. Databases
    - SQL vs NoSQL
    - In-memory DB
    - Data Replication & Migration
    - Data Partitioning
    - Sharding -> Horizontal partitioning of data.

3. Consistency vs Availability
    - Data Consistency & its levels
    - Isolation & its levels
    - CAP Theorem

4. Cache
    - What is Cache? (Radis, Memccahed)
    - Write policies: write back, through & around
    - Replacement policies: LFU, LRU, Segmented LRU etc
    - Content Delivery Network (CDNs)

5. Networking
    - TCP vs UDP
    - What is http (1/2/3) & https
    - Web sockets
    - WebRTC & Video streaming -> It will help us to create a Youtube, Netflix…

6. Load Balancers
    - Load Balancing Algorithms (Stateless & Stateful) It will help in horizontal  and vertical  scaling
    - Consistent Hashing **
    - Proxy and Reverse Proxy
    - Rate Limiting -> It prevents  the system from Ddos attack

7. Message Queues ( The main task of message queue is to handle to non-critical task)
    - Asynchronous Processing (Kafka, RabbitMQ)
    - Publisher-Subscriber Model (Pus/Sub model)

8. Monoliths and Microservices
    - Why Microservices?
    - Concept of Single Point of Failure
    - Avoiding Cascading Failure
    - Containerisation (Docker)
    - Migrating to Microservices

9. Monitoring & Logging
    - Logging events & monitoring metrics (AWS CloudWatch, Grafana, Prometheus)
    - Anomaly Detection

10. Security
    - Tokens for Auth
    - SSO & OAuth
    - Access control lists and rule engines
    - Encryption

11. System Design Tradeoffs
    - Push vs Pull architecture ( Should I’ve to push the data before asking the client (push) or we have to wait until we get any request from the client (pull))
    - Consistency vs Availability
    - SQL vs NoSQL DBs
    - Memory vs Latency
    - Throughput vs Latency
    - Accuracy vs Latency


#### Practices
- Video streaming (Youtube, Netflix, Hotstar …..
- Message plateform( Wtsapp, telegram…
- Social media plateform (fb, insta, X..
- E-Com (Amazon, Myntra, Zepto, BigBasket…
- Food delivery ( Zomato, Swiggy…
- Booking plateform ( Irctc, Airbnb, movie ticket booking,
- OLA, UBER
- Dropbox/Google Drive


### LLD

1. OOPs
    - Encapsulation, Abstraction, Inheritance, Polymorphism
    - SOlID Principles

2. Design Pattern
    - Creational Design pattern (Singleton, factory,
    - Structural Design pattern (Proxy, Bridge,…
    - Behavioural Design pattern ( Strategy, Command, Observer…

3. Concurrency & Thread safety
    - Thread safe injection
    - Locking mechanisms
    - producer-consumer
    - race conditions & synchronisation

4. UML Diagram ( It can be optional concept)
    - class digram, component diagram

5. APIs
    - API Design
    - req/res object modeling
    - versioning & extensibility
    - Clean Code Principles: DRY, Single Responsibility Principle, etc
    - Avoiding God classes

#### Common LLD Problems
1. Design a Tic-Tac-Toe or chess game
2. Desing a splitwise APP
3. Design a Parking lot
4. Design a Elevator System with multiple lifts
5. Design a Notification System
6. Design a Food delivery app
7. Movie ticket booking system
8. URL shortener
9. Logging framework
10. Rate Limiter










