package dayeight.nested;

public class Demo implements OuterInterface , OuterInterface.InnerInterface{

	@Override
	public void calArea() {
		System.out.println("Outer interface ");
		
	}

	@Override
	public void print() {
	System.out.println("inner interface ");
		
	}

}