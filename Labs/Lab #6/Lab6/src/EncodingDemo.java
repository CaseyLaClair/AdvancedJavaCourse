import java.io.*;
import java.util.*;

/**
 * This class encodes text from a file and writes it 
 * to another file. Then it reads from the new encoded file
 * and decodes.
 * @author Casey LaClair
 */
public class EncodingDemo 
{
	/**
	 * Main method
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		//Create and open files
		FileWriter fwriter = new FileWriter("Encoded.txt",true);
		PrintWriter encodedFile = new PrintWriter(fwriter);
		File testFile = new File("EncodeTest.txt");
		
		//Check if file exists in case it was deleted
		if(!testFile.exists())
		{
			System.out.println("Who took my file?!");
			System.exit(0);
		}
		
		//Create scanner for test file
		Scanner inputFile = new Scanner(testFile);
		
		System.out.println("I am encoded:\n");
		
		//Encode each line from the file
		while(inputFile.hasNext())
		{
			String str = inputFile.nextLine();
			String encoded = encode(str);
			System.out.println(encoded);
			encodedFile.println(encoded);
		
		}
		//Close file
		encodedFile.close();
		
		//Open readable version of new file
		File eFile = new File("Encoded.txt");
		Scanner coded = new Scanner(eFile);
		
		System.out.println("\nI am decoded:\n");
		
		//Decode each lineof encoded file
		while(coded.hasNext())
		{
			String str = coded.nextLine();
			String decoded = decode(str);
			System.out.println(decoded);
		
		}
		
		//Close files
		coded.close();
		inputFile.close();
	}
	
	/**
	 * This method encodes a string
	 * @param str to encode
	 * @return encoded string
	 */
	public static String encode(String str) 
	{
		//Create char array from string
	    char[] toEncode = str.toCharArray();
	    
	    //Encode each letter by moving 5 spaces in the alphabet
	    for (int i = 0; i < toEncode.length; i++) 
	    {
	        if (Character.isLetter(toEncode[i])&&Character.isUpperCase(toEncode[i])) 
	        {
	        	toEncode[i] = (char) ((toEncode[i] + 5 - (int)'A') % 26 + (int)'A');
	        }
	        
	        if (Character.isLetter(toEncode[i])&&Character.isLowerCase(toEncode[i])) 
	        {
	        	toEncode[i] = (char) ((toEncode[i] + 5 - (int)'a') % 26 + (int)'a');
	        }
	    }
	    
	    //Convert char array to string
	    str = arrayToString(toEncode);
	    return str;
	}
	
	/**
	 * This method decodes a string
	 * @param str to decode
	 * @return decoded string
	 */
	public static String decode(String str) 
	{
		//Create char array from string
	    char[] toDecode = str.toCharArray();
	    
	    //Decode each letter by moving 5 spaces in the alphabet
	    for (int i = 0; i < toDecode.length; i++) 
	    {
	        if (Character.isLetter(toDecode[i])&&Character.isUpperCase(toDecode[i])) 
	        {
	        	toDecode[i] = (char) ((toDecode[i] - 5 - (int)'Z') % 26 + (int)'Z');
	        }
	        
	        if (Character.isLetter(toDecode[i])&&Character.isLowerCase(toDecode[i])) 
	        {
	        	toDecode[i] = (char) ((toDecode[i] - 5 - (int)'z') % 26 + (int)'z');
	        }
	    }
	  //Convert char array to string
	    str = arrayToString(toDecode);
	    return str;
	}
	
	/**
	 * Converts an array to a string
	 * @param charArray
	 * @return string 
	 */
	public static String arrayToString(char[] charArray)
	{
		//Create an empty StringBuilder for accumulating the characters of the charArray
		StringBuilder newString=new StringBuilder();
		
		//Iterate through the charArray and append all characters to the StringBuilder
		for (int i=0; i<charArray.length; i++)
		{
			newString.append(charArray[i]);
		}
		
		//Convert the StringBuilder to a String and return
		return newString.toString();
	}
}
