import javax.swing.*;


/**
 * Recursive summation example
 * @author Casey LaClair
 */
public class SummationDemo {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		int number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number for summation: "));
		
		JOptionPane.showMessageDialog(null, "Recursion:\nThe sum from 1 to "+number+" is "+sumOfInts(number));
	}
	
	/**
	 * This is the recursive method for summation.
	 * @param n - number to sum to
	 * @return sum of numbers
	 */
	public static int sumOfInts(int n) {
		
		//Base case
		if(n<=0) {
			return 0;
		}
		//Recursive case, add n to n-1...etc
		else {
			return (n+sumOfInts(n-1));
		}
	}
}
