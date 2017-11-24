/**
 * @author Casey
 * This lab class demonstrates the use of recursion for 
 * exponential numbers and palindrome detection.
 */
public class RecursionLab {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		//Declare and init test strings
		String test = "I am not a palindrome";
		String test2 = "palindrome emordnilap";

		//Test exponent recursion
		System.out.println(expoRecursion(2, 5));

		//Test palindrome text
		if (palindromeCheck(test))
			System.out.println(test+" : is a palindrome");
		else
			System.out.println(test+" : is not a palindrome");

		if (palindromeCheck(test2))
			System.out.println(test2+" : is a palindrome");
		else
			System.out.println(test2+" : is not a palindrome");
	}

	/**
	 * Computes the exponent of a number
	 * @param base - number to be raised
	 * @param exponent - power to raise the base
	 * @return answer
	 */
	public static int expoRecursion(int base, int exponent) {

		//Base case when exponent = 0,
		//else call again with a decreased exponent by 1
		if (exponent == 0)
			return 1;
		else
			return base * expoRecursion(base, exponent - 1);
	}

	/**
	 * Checks if a string is a palindrome
	 * @param str - string to be checked
	 * @return boolean whether or not its a palindrome
	 */
	public static boolean palindromeCheck(String str) {

		//Base case is when string is only one character
		//else, compare 1st and last char. If they're equal,
		//go to 2nd letter and 2nd from last to compare... etc
		if (str.length() <= 1)
			return true;
		else if (str.charAt(0) == str.charAt(str.length() - 1))
			return palindromeCheck(str.substring(1, str.length() - 1));

		return false;
	}

}
