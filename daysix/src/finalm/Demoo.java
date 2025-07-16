package finalm;

// Final class Demo
public final class Demo {
    void show() {
        System.out.println("Final class cannot be inherited");
    }
}

// Main class to run the program
public class Class {
    public static void main(String[] args) {
        Demo f = new Demo();
        f.show();
    }
}
