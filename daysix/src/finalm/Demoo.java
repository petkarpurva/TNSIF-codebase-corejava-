package finalm;

public class Demoo {
	void show() {
        System.out.println("Final class cannot be inherited");
    }
}

// Main class to run the program
public class Demoo {

    public static void main(String[] args) {
        Demo f = new Demo();
        f.show();
    }
}
