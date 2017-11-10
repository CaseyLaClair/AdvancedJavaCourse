
public class StringOpsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		String test1="If I had a monkey, I would teach him how to do my hair -  using the appropriate amount of product.";
		String test2="“This is a story about a single-issue campaign that metastasized,” he said, when I first heard him talk about “Prohibition” last year.";
		String test3="As Kozinski vividly writes, the freedom to lie is at stake in  United States v. Alvarez, a Ninth Circuit case in which the government, defeated below, has just filed for certiorari in the Supreme Court.";
		
		//Testing wordCount:
		System.out.println("Number of words in: ");
		System.out.println(test1);
		System.out.println(StringOps.wordCount(test1));
		
		System.out.println();
		System.out.println("Number of words in: ");
		System.out.println(test2);
		System.out.println(StringOps.wordCount(test2));
		
		System.out.println();
		System.out.println("Number of words in: ");
		System.out.println(test3);
		System.out.println(StringOps.wordCount(test3));
		
		//Testing arrayToString:
		System.out.println(StringOps.arrayToString(test1.toCharArray()));
		
		//Testing frequency and mostFrequent:
		String test4="aAaAaA bBbBb ZZZZ";
		int[] frequencyArray = StringOps.frequency(test4);
		for (int i=0; i<frequencyArray.length;i++){
			System.out.println((char)(i+(int)'a')+": "+frequencyArray[i]);
		}
		System.out.println("Most frequent character: "+StringOps.mostFrequent(test4));
		
		//testing replaceSubString
		String test5="the dog jumped over the fence";
		System.out.println(StringOps.replaceSubstring(test5, "fence", "tin can"));

	}
		
}