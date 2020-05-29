package fibonacci;
import java.util.Scanner;



public class fibonacci {
	
	
	
	Scanner input = new Scanner ( System .in );
	
	long n;
	public static long fibo_sequenza(long n) {      //sequenza di fibonacci che parte da 0--->0 1 1 2 3 5 8 13 21 34 55 89 144 233....//
		if(n==1 || n==0) {
			return n ;
		}
		else {
			return (fibo_sequenza(n-2)+fibo_sequenza(n-1));		
		}
	}

	
public static void main ( String [] args ) {
     for (int j=1;j<=3;j++) {
	Scanner input = new Scanner ( System .in );         //scrive 3 num della sequenza di fibonacci//
	
	long i= input.nextInt();
		long ris= fibo_sequenza(i);
		System.out.println(ris);
		
	}
	
}

}

		



	

	
	
   
				
				
			
			