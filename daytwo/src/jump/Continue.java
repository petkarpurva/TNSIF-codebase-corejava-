package jump;

public class Continue {
	public static void main(String[] args) {
		
		for (int k=5; k<100; k++)
		{
			//odd no are skipped
			if (k%2 !=0)
				continue;	//skips the current iteration
			
			//even no are printed
			System.out.println(k + " ");
		}
	}

}
