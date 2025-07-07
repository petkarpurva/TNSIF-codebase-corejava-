package dayseven.overloading;

public class Demo {
	public static void main(String[] args) {
		Point p = new Point(23, 12);	//default
				System.out.println(p);
		
		Point p1 = new Point (20.09f, 23.45f);	//constructor overloading
		System.out.println(p1);
	}
}
