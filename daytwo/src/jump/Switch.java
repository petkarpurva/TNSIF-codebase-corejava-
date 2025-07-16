package jump;

public class Switch {
	public static void main(String[] args) {
		
		int input = 3;
		
		switch(input)
		{
			case 1: System.out.println("current recharge details");
			break;
			
			case 2: System.out.println("current recharge expiry");
			break;
			
			case 3: System.out.println("new offers");
			break;
			
			case 4: System.out.println("talk to our customer support");
			break;
			
			default: System.out.println(input + " isn't a valid input");
		}
	}
}
