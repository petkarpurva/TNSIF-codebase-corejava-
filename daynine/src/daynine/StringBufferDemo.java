package daynine;

public class StringBufferDemo {
    public static void main(String[] args) {

        // StringBuffer length and capacity
        StringBuffer buffer = new StringBuffer("Hello");
        System.out.println(buffer);             // Output: Hello
        System.out.println(buffer.length());    // Output: 5
        System.out.println(buffer.capacity());  // Default capacity (16) + 5 = 21

        // Appending and inserting into buffer
        String s;
        int a = 42;
        buffer = new StringBuffer(40);          // Initial capacity set to 40
        s = buffer.append("a=").append(a).append("!").toString();
        System.out.println(s);                  // Output: a=42!
        System.out.println(buffer);             // Output: a=42!

        // Inserting and deleting
        buffer = new StringBuffer("I Java");
        buffer.insert(2, "like ");              // Insert "like " at index 2
        System.out.println(buffer);             // Output: I like Java

        buffer.delete(3, 6);                    // Delete characters from index 3 to 6 (excluding 6)
        System.out.println(buffer);             // Output: I lke Java

        System.out.println(buffer.reverse());   // Output: avaJ ekl I
    }
}
