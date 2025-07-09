package dayseven.overriding;

public class Demo {
public static void main(String[] args) {
		
		rbi rbi;
		
		//Dynamic binding assigning child object to parent class reference variable 
		rbi=new sbi();
		System.out.println(rbi.getRateofInterest());
		
		rbi=new icici();
		System.out.println(rbi.getRateofInterest());
		
		rbi=new hdfc();
		System.out.println(rbi.getRateofInterest());

	}

}
