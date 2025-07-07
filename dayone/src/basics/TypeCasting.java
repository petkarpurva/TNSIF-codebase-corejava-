package basics;

public class TypeCasting {
	public static void main(String[] args) {
		
		//widening or implicit typecasting
		byte b = 10;
		int i = b;
		System.out.println(i);
		
		float f = 22.14f;
		double d = f;
		System.out.println(d);
		
		//narrowing or explicit typecasting
		double f1 = 10.52f;
		long l1 = (long) f1;
		System.out.println(l1);
		
		long l2 = 7020132315L;
		int i2 = (int) l2;
		System.out.println(i2);
		
		short a = 135;
		byte b1 = (byte) a;
		System.out.println(b1);
		
		//byte -128 to 127
		//130 - 128 = 2
	}

}
