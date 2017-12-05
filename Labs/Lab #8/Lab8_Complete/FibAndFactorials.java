import java.text.DecimalFormat;
import java.util.Date;

public class FibAndFactorials {

	public static void main(String[] args) {
	
		//Compute iterative factorial
		System.out.println("ITERATIVE FACTORIAL");
		for(int i=8; i<13; i++) {
			long start = System.nanoTime();
			
			long answer = factiter(i);
			System.out.println("Factorial of "+i+" = "+answer);
			
			long elapsedTime = System.nanoTime()-start;
			double seconds = ((double)elapsedTime/1000000000);
			double milli = ((double)elapsedTime/1000000);
			
			System.out.println("Time to compute in seconds = "+new DecimalFormat("#.##########").format(seconds));
			System.out.println("Time to compute in milliseconds = "+new DecimalFormat("#.##########").format(milli)+"\n");
		}	
		
		//Compute recursive factorial
		System.out.println("RECURSIVE FACTORIAL");
		for(int i=8; i<13; i++) {
			long start = System.nanoTime();
			
			long answer = factorial(i);
			System.out.println("Factorial of "+i+" = "+answer);
			
			long elapsedTime = System.nanoTime()-start;
			double seconds = ((double)elapsedTime/1000000000);
			double milli = ((double)elapsedTime/1000000);
			
			System.out.println("Time to compute in seconds = "+new DecimalFormat("#.##########").format(seconds));
			System.out.println("Time to compute in milliseconds = "+new DecimalFormat("#.##########").format(milli)+"\n");
		}	
		
		//Compute the nth value of the fibonacci series
		System.out.println("ITERATIVE FIBONACCI");
		for(int i=45; i<51; i++) {
			long start = System.nanoTime();
			
			long answer = fibIteration(i);
			System.out.println("The "+i+" number in the fibonacci series is "+answer);
			
			long elapsedTime = System.nanoTime()-start;
			double seconds = ((double)elapsedTime/1000000000);
			double milli = ((double)elapsedTime/1000000);
			
			System.out.println("Time to compute in seconds = "+new DecimalFormat("#.##########").format(seconds));
			System.out.println("Time to compute in milliseconds = "+new DecimalFormat("#.##########").format(milli)+"\n");
		}	
	}
	
	/**
	 * This method takes in an nth value and finds
	 * the number at that value.
	 * @param nth term in the fib series
	 * @return value of fib number
	 */
	public static long fibIteration(int n) {
        long x = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }
	
	public static int factiter(int num) {
		int factorial=1;
		int i;
		for (i=2; i<=num; i++)
			factorial*=i;
		return factorial;
	}
	
	//Here's the recursive factorial we're to convert:
	private static int factorial(int n) {
	      if (n == 0)
	         return 1;   // Base case
	      else
	         return n * factorial(n - 1);
	   }

}
