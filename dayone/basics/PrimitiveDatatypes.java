package basics;

public class PrimitiveDatatypes {
	public static void main(String[] args) 
	{	
		//byte take 1 byte
		//1 byte - 8 bits
		byte bmax = 127;
		byte bmin = -128;
		System.out.println("minimum range of byte:" +bmin +"maximum range of byte" +bmax);
	
		//short = 2byte
		short smax = 32767;
		short smin = -32768;
		System.out.println("minimum range of short:" +smin +"maximum range of short" +smax);
		
		//int = 4byte
		int imax = 214783647;
		int imin = -214783648;
		System.out.println("minimum range of integer:" +imin +"maximum range of integer" +imax);
		
		//long = 8byte
		long lmax = 9223372036854775807L;
		long lmin = -9223372036854775808L;
		System.out.println("minimum range of long:" +lmin +"maximum range of long" +lmax);
		
		float f = 3234.141243278345f;
		double d = 3456.14124512345678902345678914f;
		
		boolean flag = false;
		boolean flag2 = true;
	}
}
