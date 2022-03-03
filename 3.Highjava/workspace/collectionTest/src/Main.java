
import java.util.Scanner;


public class Main{
	public static void main(String [] args){
		
		Scanner s = new Scanner(System.in);
		
		double input = s.nextDouble();
		
		double res = (input * 9/5) + 32; 
		
		System.out.printf("%.3f", res);
		
	}
	
}