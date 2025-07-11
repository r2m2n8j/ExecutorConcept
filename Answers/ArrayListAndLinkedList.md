- Is array list dynamic or static? dynamic
- Difference between Array, Arraylist and Linked list?
- And Internal working of Arraylist? And what data structure works internally in arraylist?
- When should use ArrayList And when use linked list?
- Linked list internal implementation
- How Linked list maintains insertion order?


- In Java, Array, ArrayList, and LinkedList are distinct data structures used to store collections of elements, each with its own characteristics and performance implications.
1. **Array:**
   - **Fixed Size:**
     - Arrays in Java have a fixed size determined at the time of creation. Once declared, their size cannot be changed.
   - **Contiguous Memory:**
      - Elements are stored in contiguous memory locations, allowing for efficient random access to elements using an index (O(1) time complexity).
   - **Homogeneous Elements:**
     - Arrays can only store elements of the same data type.
   - **Direct Memory Access:**
     - Provides direct access to memory, potentially leading to slightly better performance for certain operations compared to ArrayList or LinkedList in specific scenarios.
2. **ArrayList:**
   - **Dynamic Array:**
     - ArrayList is a dynamic array implementation of the List interface, meaning its size can grow or shrink as elements are added or removed. Internally, it uses a resizable array.
   - **Random Access:**
     - Offers fast random access to elements by index (O(1) time complexity) due to its underlying array structure.
   - **Inefficient Insertions/Deletions in the Middle:**
     - Inserting or deleting elements in the middle of an ArrayList can be slow (O(n) time complexity) because it requires shifting subsequent elements in the internal array.
   - **Memory Overhead:**
     - May have some memory overhead due to the need to potentially resize the underlying array when capacity is exceeded.
3. **LinkedList:**
   - **Doubly Linked List:**
     - LinkedList is an implementation of the List and Deque interfaces using a doubly linked list. Each element (node) stores a reference to the previous and next elements.
   - **Efficient Insertions/Deletions:**
     - Provides efficient insertions and deletions at any position (O(1) time complexity) because only the pointers of adjacent nodes need to be updated.
   - **Slow Random Access:**
     - Accessing elements by index can be slow (O(n) time complexity) as it requires traversing the list from the beginning or end to reach the desired element.
   - **Memory Overhead:**
     - Each node stores references to the previous and next nodes, leading to higher memory overhead compared to ArrayList.
   - **Queue and Deque Operations:**
     - LinkedList also supports efficient queue and deque operations (e.g., addFirst, removeLast).


## And Internal working of Arraylist? And what data structure works internally in arraylist?
- The core of an ArrayList is a dynamic array, specifically an Object[] array (an array of objects). This array holds the elements that are added to the ArrayList.

- Unlike fixed-size arrays, ArrayLists can automatically grow in size as elements are added or removed.
  - **Initial Capacity**: When an ArrayList is created using the default constructor, it has an initial capacity of 10. You can also specify an initial capacity when creating an ArrayList instance.
  - **Adding Elements**: When an element is added to an ArrayList, it first checks if there's enough space in the underlying array. If the array is full (the size exceeds the capacity), the ArrayList increases the capacity of the array.
  - **Resizing Process**: When resizing, a new, larger array is created (typically 50% larger than the old array in Java 8 and later versions), and the old elements are copied into the new array using **Arrays.copyOf()** or **System.arraycopy()** methods.
  - **Removing Elements**: When elements are removed, the elements that come after the removed element are shifted to the left to fill the gap, and the size of the array is decreased.

- Performance
  - **Random Access (get() operation)**: Fast, with O(1) time complexity, due to the index-based access of the underlying array.
  - **Adding/Removing elements at the end**: Efficient (amortized O(1)), as elements are just appended or removed without shifting.
  - **Inserting/Deleting elements in the middle**: Can be slow (O(n) time complexity) because the subsequent elements need to be shifted to accommodate the change or close the gap.











