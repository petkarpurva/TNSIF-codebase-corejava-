package basics;

public class CharDemo {
    // char takes a single input/character at a time
    // it's used to store a single 16-bit Unicode character

    public static void main(String[] args) {

        // 1. Basic char assignment
        char ch = 'a';
        System.out.println("ch: " + ch); // Output: a

        // 2. Assigning number to char (ASCII value of 65 = 'A')
        char ch1 = 65;
        System.out.println("ch1 (from 65): " + ch1); // Output: A

        // 3. Assigning a char to int (gives Unicode/ASCII value)
        int code = 'A';
        System.out.println("Unicode/ASCII of 'A': " + code); // Output: 65

        // 4. Assigning a Unicode to char (\u20AC = € symbol)
        char unicodeChar = '\u20AC';
        System.out.println("Unicode character: " + unicodeChar); // Output: €

    }
}
