

- **Start ->**
  - Intermediate Operations

        filter  map   flatMap   distinct    sorted    peek    limit      skip 
    - Terminal Operators

              forEach   collect     reduce    allMatch      findFirst     findAny     min     max     toArray
  - Collectors

              joining     groupingBy      counting

- **End ->**

### map()
- Transforms each element of the stream using a function.
- Returns a Stream of transformed elements.
- One-to-one mapping.

        List<String> words = List.of("hello", "world");
        List<Integer> lengths = words.stream()
            .map(String::length)
            .collect(Collectors.toList());
        
        // Output: [5, 5]

      __________________________________________________
      List<List<String>> listOfLists = List.of(
          List.of("a", "b"),
          List.of("c", "d")
        );

      Stream<Stream<String>> mapped = listOfLists.stream()
          .map(list -> list.stream());

      // Output: Stream<Stream<String>>



### flatMap
- **flatMap** is an intermediate operation that transforms each element of a stream into zero or more elements of a new stream, and then concatenates those resulting streams into a single, flattened stream.
  - **Key characteristics of flatMap:**
    - **Transformation and Flattening:**
      - It combines the concepts of mapping and flattening. It first applies a mapping function to each element of the original stream, where this function **returns a Stream** (or a **Stream of a primitive type like IntStream, LongStream, DoubleStream**). Then, it takes all the elements from these individual streams and merges them into a single, cohesive stream.
    - **Handling Nested Structures:**
      - flatMap is particularly useful when dealing with **nested collections or structures**, such as a **List of Lists**, or **an object containing a collection of other objects**. It allows you to "flatten" these nested structures into **a single stream of individual elements**.
    - **One-to-Many Transformation:**
      - Unlike **map**, which typically performs a **one-to-one transformation** (one input element maps to one output element), flatMap enables **a one-to-many transformation**, where a single input element can produce multiple output elements within the flattened stream.

- **flatMap is a two-step process:**
  - Map: Convert each element into a new stream (in your case, each inner list becomes a stream).
  - Flatten: Merge all those streams into a single stream.

    - I have a list of list (2D List) and I want to convert it into Single List
    
            List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("book", "pen", "Pencil","Paper"),
                Arrays.asList("Computer", "Laptop", "Mouse", "Keyboard")
            );
      - **without Stream API Interface**

            List<String> ans  = new ArrayList<>();
            for(List<String> list : listOfList){
                ans.addAll(list);
            }
            return ans;
      - **With Stream API Interface**  

            return listOfList.stream()
                  .flatMap(List::stream)
                  .toList();
        - **Let's break above code line by line**

                  listOfList.stream()
          - This gives a Stream<List<String>>. Each element of this stream is a List<String>.
            
                  .flatMap(List::stream)
          - This means: for each **List<String>** inside the stream, call .stream() on it.
          - So you convert Stream<List<String>> to Stream<Stream<String>>
          - But flatMap automatically flattens it into a Stream<String>

  
#### Distinct 
- distinct is used to remove duplicate items from the list.
- We can do this with the help of set but in set order of item may not be same as list.
- But distinct preserve the order of items.


      public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,3,4,5,4,5,6,6,7,8);
        System.out.println(
                list.stream()
                        .distinct()
                        .toList()
        );
      }


#### Sorted
- It is used to sort the list.
- With the help of sort we can sort the list in natural sorting order or reverse sorting order.


       private static List<Integer> sortInReverseSortingOrder(List<Integer> number) {
        return number.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
      }

      private static List<Integer> sortInNaturalSortingOrder(List<Integer> number) {
          return number.stream()
                  .sorted()
                  .collect(Collectors.toList());
      }




#### Peak
- The peek method in Java Streams is primarily used for debugging purposes. It allows you to perform an intermediate operation on each element of the stream without modifying the stream itself.
- It is used when we want to debug intermediate operation. 
- Because It is difficult to know what is happening inside the stream intermediate operation. At that time peek with help us. So If we want we can do logging inside the peek so it will not affect the stream as well as it will give us clear view.


#### limit
- Limit is an intermediate operation. It will use to limit the stream object.
- In a list have n numbers, and we want to perform task only on 5 then we used limit(5);

#### skip
- skip is used to skip some part in the stream.
- Suppose I have a list on integer and I want to skip first 5 number and return remaining number than we have to use skip(5).


#### reduce
- The reduce method in Java Streams is used to perform a reduction on the elements of a stream, combining them into a single result.
- It applies a binary operation ( a function that takes two arguments and returns a single result) to the elements of the stream, repeatedly until all elements have been processed and a single value remains.

      List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        Optional<Integer> result = numbers.stream()
                .reduce((a,b) -> a * b);

        System.out.println(result.get());
      Output - 120


- Steps of Reduction:
  1. Start with the first two elements : 1 * 2 = 2
  2. Multiply the result with the next element : 2 * 3 = 6
  3. Multiply the result with the next element : 6 * 4 = 24
  4. Multiply the result with the last element : 24 * 5 = 120



#### allMatch
- allMatch method in Java Streams is used to check if all elements in the stream satisfy a given predicate.
- It returns true if every element in the stream matches the predicate, and false otherwise.

      list = 1,2,3,4,5
      list.stream().allMatch(n -> n > 0);
      output = true
      
      list1 = 1,2,3,4,-1,2,3,4,5,6,78,9
      list.stream().allMatch(n -> n > 0);
      output = false

- even it not check whole list items it found n = -1 and it is less than 0 it returns false immediately.




# Short-Circuiting
- The allMatch operation is short-circuiting, meaning it stops processing as soon as it finds the first element that does not match the predicate.
- If it finds such an element, it immediately returns false.


#### anyMatch
- The anyMatch method checks whether al least one element in the stream matches a given **predicate**.
- It returns true as soon as it finds an element that satisfies the predicate and stops.
- Future processing. If no elements match it return false.
- anyMatch is **short-circuiting**, meaning it stops processing as soon as it finds the first element that matches the predicate, optimizing performance.



#### noneMatch
- The noneMatch method in Java Streams is used to check if no elements in the stream match a given predicate.
- It returns true if none of the elements satisfy the predicate and false if at least one element does.
- Like allMatch and anyMatch, noneMatch is short-circuiting. 
- It stops processing as soon as it finds the first element that matchs the predicate and immediately return false.



#### findFirst and findAny
- findFirst is used to retrieve the first element in a stream that matches a given condition or simply the first element in the stream if no filtering is applied.
- It returns the first element wrapped in an Optional, which is a container object that may or may not contain a non-null value.

- retrieve any element from the stream that matches a given condition, or simply any element form the stream if no filtering is applied.
- It returns the element wrapped in an Optional which may or may not contain a value.


#### max and min

- Used to find the maximum and minimum elements in a stream, respectively, based on a given comparator or natural ordering.
- These methods return an **Optional** because the **stream might be empty**.



#### toArray
- When we want to convert collection into array.

      List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Guava");
      String [] result = words.stream().toArray(String[] :: new);
      output: ["Apple", "Banana", "Cherry", "Guava"]


# Collectors

### joining
- is used to concatenate the elements of a stream into a single String.
- It's part of the Collectors utility class and provides a convenient way to aggregate elements into a string format with optional **delimiters, prefixes, and suffixes**.

        List<String> list = Arrays.asList("anuj", "kumar","mishra");
        System.out.println(
                list.stream()
                        .collect(Collectors.joining(", "))
        );
        Outpur = anuj, kumar, mishra

        List<String> list = Arrays.asList("anuj", "kumar","mishra");
        System.out.println(
                list.stream()
                        .collect(Collectors.joining(", ", "[","]"))
        );

        output = [anuj, kumar, mishra]



#### groupingBy
- group elements of the stream by a specified classifier function.
- It is a powerful feature provided by the Collectors utility class and is commonly used for **aggregating and categorizing** data into a **Map**
- Where keys are the result of applying the classifier function and the values are lists of items corresponding to each key.

          Map<String, Optional<Employee>> result = list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

##### Stream.iterator
- 🔹 Stream.iterate – WHY?
- We use Stream.iterate when we want to generate a sequence of values by applying a function repeatedly, instead of pulling from a collection.
- It’s often useful for creating infinite streams or sequences with a clear pattern.

- 🔹 Syntax (Java 9+)
                
                Stream.iterate(seed, predicate, function)


        - seed → starting value
        - predicate → condition to continue (stopping condition)
        - function → how to compute the next element


                Stream.iterate(1, n -> n <= 10, n -> n + 1)
                .forEach(System.out::println);

                👉 Prints 1 to 10
                        Here:
                        Start = 1
                        Continue while n <= 10
                        Next value = n + 1


                Stream.iterate(0, n -> n <= 20, n -> n + 2)
                .forEach(System.out::println);

                👉 Prints 0, 2, 4, ..., 20


- 🔹 Example 3 – Infinite stream (Java 8 style)
- Before Java 9, Stream.iterate only had (seed, function) → infinite stream.

                Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);

                👉 Prints 1 to 10 (we use limit() to stop)

- 🔹 Example 4 – Fibonacci using iterate

                Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

                👉 Prints first 10 Fibonacci numbers.










# Q1. How do you perform bulk operations on streams in Java?

- Bulk operations on streams can be performed using various methods such as forEach, collect, map, filter, reduce, etc. These operations allow you to manipulate and process elements of a stream in bulk.

# Q2. Explain the usage of collect method in Java streams with examples.

- The collect method in Java streams is used to accumulate the elements of a stream into a collection or to perform a mutable reduction. It takes a Collector as an argument, which specifies how to accumulate elements into the resulting collection. Here's an example:

        List<String> names = Arrays.asList("John", "Alice", "Bob", "Jane");
        String concatenatedNames = names.stream()
        .collect(Collectors.joining(", "));
# Q3. How do you handle infinite streams in Java?

- Infinite streams in Java are streams that have no fixed size and can potentially produce an unlimited number of elements. You can work with infinite streams by applying short-circuiting operations like limit, findFirst, or findAny to control the number of elements processed.

# Q4. Explain the concept of early termination in Java streams.

- Early termination in Java streams refers to the ability to stop processing elements as soon as a certain condition is met, rather than processing the entire stream. This can be achieved using short-circuiting operations like findFirst, findAny, anyMatch, allMatch, noneMatch, or limit.

# Q5. How do you handle concurrency issues in parallel streams?

- Concurrency issues in parallel streams can be handled by ensuring that stream operations are stateless and do not rely on mutable shared state. Additionally, synchronization mechanisms like synchronized blocks or Atomic classes can be used when accessing shared mutable state.

# Q6. What are the common pitfalls to avoid when using Java streams?

- Not understanding the difference between intermediate and terminal operations.
- Using stateful intermediate operations, which can lead to unpredictable results in parallel streams.
- Not handling potential NullPointerExceptions when using operations like map, flatMap, or filter.
- Forgetting to handle exceptions thrown by stream operations.
# Q7. Explain the usage of Stream.concat method in Java.

- The Stream.concat method in Java is used to concatenate two streams into a single stream. It takes two streams as arguments and returns a new stream consisting of the elements of the first stream followed by the elements of the second stream.

        List<String> list1 = Arrays.asList("apple", "banana", "orange");
        List<String> list2 = Arrays.asList("grape", "melon", "pineapple");
        
        Stream<String> stream1 = list1.stream();
        Stream<String> stream2 = list2.stream();
        
        Stream<String> concatenatedStream = Stream.concat(stream1, stream2);
        concatenatedStream.forEach(System.out::println);
# Q8. How do you create a stream of random numbers in Java?

- You can create a stream of random numbers in Java using the Random class along with the Stream.generate method. For example:

        Random random = new Random();
        Stream<Integer> randomNumbers = Stream.generate(random::nextInt);
# Q9. What are the performance considerations when using parallel streams in Java?

- Overhead: There is overhead associated with thread management, context switching, and synchronization.
- Parallelization overhead: The cost of dividing the work among multiple threads and merging the results can sometimes outweigh the benefits of parallelism.
- Data characteristics: Parallel streams perform best on large datasets with computationally intensive operations that can be parallelized.
- Statelessness: Operations in parallel streams should be stateless to avoid synchronization issues and ensure correct behavior in concurrent execution.
- Thread safety: If mutable state is shared among parallel stream operations, proper synchronization mechanisms should be employed to prevent data races and ensure thread safety.
# Q10. How do you implement a stream pipeline that performs multiple transformations and aggregations?

- You can implement a stream pipeline that performs multiple transformations and aggregations by chaining together multiple intermediate operations followed by a terminal operation. Each intermediate operation transforms the stream in some way, while the terminal operation collects or aggregates the results. For example:

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers
        .stream()
        .filter(n -> n % 2 == 0)    // Filter even numbers
        .mapToDouble(n -> n * 2.0)  // Map to doubles and multiply by 2
        .average()                  // Calculate the average
        .orElse(0);                 // If no average, return 0
# Q11. Explain the usage of Stream.Builder in Java.

- Stream.Builder is a helper interface in Java used to build streams. It allows you to manually add elements to a stream one-by-one and then build the final stream. This is useful when you need to construct a stream dynamically. Here's an example:

        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
        builder.add(2);
        builder.add(3);
        Stream<Integer> stream = builder.build();
# Q12. How do you perform grouping and aggregation operations on Java streams?

- Grouping and aggregation operations on Java streams can be performed using the Collectors.groupingBy and Collectors.summarizingInt (or similar) collectors. These collectors allow you to group elements based on certain criteria and perform aggregation operations like sum, average, count, etc. For example:

        List<String> names = Arrays.asList("John", "Alice", "Bob", "Jane");
        Map<Integer, Long> countByNameLength = names
        .stream()
        .collect(Collectors.groupingBy(String::length, Collectors.counting()));
# Q13. Explain the difference between filter and flatMap operations in Java streams.

- Filter: The filter operation is used to select elements from a stream based on a given predicate. It returns a stream consisting of the elements that match the predicate.
- FlatMap: The flatMap operation is used to transform each element of a stream into zero or more elements of another stream. It flattens the resulting streams into a single stream.
# Q14. How do you handle null values in Java streams?

- If you’re applying functions to stream elements that may return null, you should handle null values explicitly within the function to avoid NullPointerExceptions.

        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");
        List<String> filteredList = list.stream()
        .map(s -> {
        if (s == null) {
        return "N/A";
        }
        // Perform other operations
        return s.toUpperCase();
        })
        .collect(Collectors.toList());
- If you’re dealing with methods that may return null, you can wrap the values in an Optional to handle null values more gracefully.

        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");
        List<Optional<String>> optionalList = list.stream()
        .map(Optional::ofNullable)
        .collect(Collectors.toList());
- You can use the filter method to remove null values from the stream before performing further operations. This ensures that downstream operations won't encounter null values.

        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");
        List<String> nonNullList = list.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

# Q15. How do you create a custom stream source in Java?

- To create a custom stream source in Java, you can implement the Spliterator interface to define the iteration logic for your data source, and then use StreamSupport.stream() to create a stream from your custom spliterator. Here's a basic example:

        Spliterator<String> customSpliterator = new CustomSpliterator();
        Stream<String> customStream = StreamSupport.stream(customSpliterator, false);

# Q16. Explain the usage of Stream.ofNullable method in Java.

- The Stream.ofNullable method in Java was introduced in JDK 9. It creates a stream with a single element if the provided value is non-null, or an empty stream if the value is null. This is useful for avoiding null checks when working with streams. For example:

        String name = null;
        Stream<String> stream = Stream.ofNullable(name);

# Q17. How do you create a stream from an array in Java?

- You can create a stream from an array in Java using the Arrays.stream() method. This method takes an array as an argument and returns a stream of the array's elements. For example:

        int[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(numbers);

# Q18. Explain the usage of Stream.empty method in Java.

- The Stream.empty method in Java returns an empty sequential stream. This stream contains no elements and can be useful as a placeholder or default value when no other stream is available. For example:

        Stream<String> emptyStream = Stream.empty();
# Q19. Explain the concept of statefulness in Java streams.

- Statefulness in Java streams refers to whether the operations on the stream maintain state or not. Stateful operations depend on the state of previously processed elements and may store or maintain state across multiple elements. Examples of stateful operations include sorted, distinct, and limit. Statefulness can impact the parallelization and performance of stream operations.


















