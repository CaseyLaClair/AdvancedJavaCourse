import java.io.*;
import java.util.*;

/**
 * This class summarizes data of student grades from a text file. 
 * It then saves the summary in a new text file.
 * @author Casey LaClair
 */
public class GradesSummary {

	//Declare variables
	String[] courseSummary = new String[7];
	static String[] courseGrade = new String[7];
	final static String HEADER = "Course No.\tSubject\tCourse\tCourse Title\tA\tA-\tB\tB-\tB+\tC\tC+\tD\tD+\tF\tI\tW\tTransfer\tPassing";

	// Slots are [A, A-, B, B-, B+, C, C+, D, D+, F, I, W]
	static int[] grades = new int[12];

	/**
	 * Main method
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//Test file with grades data
		File inputFile = new File("cmp110.txt");
		Scanner scanner = new Scanner(inputFile);

		//Find out how many times a grade appears
		while (scanner.hasNext()) {

			String line = scanner.nextLine();

			courseGrade = line.split("\\t");
			countGrades(courseGrade[5]);

		}

		//Output summary and close scanners
		PrintWriter output = new PrintWriter("GradeSummary.txt");
		output.println(HEADER);
		output.println(courseSummary());
		output.close();
		scanner.close();
	}

	/**
	 * Generates a course summary of data
	 * @return course summary statement
	 */
	public static String courseSummary() {

		String str, courseNum, subject, course, title;

		courseNum = courseGrade[0];
		subject = courseGrade[2];
		course = courseGrade[4];
		title = courseGrade[3];

		str = courseNum + "\t" + subject + "\t" + course + "\t" + title + "\t" + printGrades() +findTransfer()
				+ "\t\t"+findPassing();

		return str;
	}

	/**
	 * Creates a tab delimited stringbuilder of grades
	 * @return StringBuilder of grades
	 */
	public static StringBuilder printGrades() {

		StringBuilder string = new StringBuilder();

		for (int s : grades)
			string.append(s + "\t");

		return string;
	}

	/**
	 * Find transfers from data
	 * @return total transfers
	 */
	public static int findTransfer() {
		int transfer = 0;

		for (int i = 0; i < 7; i++) {
			transfer += grades[i];
		}

		return transfer;
	}

	/**
	 * Find passing grades total from data
	 * @return total passing grades
	 */
	public static int findPassing() {
		int passing = 0;

		for (int i = 0; i < 9; i++) {
			passing += grades[i];
		}

		return passing;
	}

	/**
	 * Probably longer than necessary method that increments
	 * how many times a grade appears.
	 * @param grade incremented
	 */
	public static void countGrades(String grade) {

		switch (grade) {
		case "A":
			grades[0]++;
			break;
		case "A-":
			grades[1]++;
			break;
		case "B":
			grades[2]++;
			break;
		case "B-":
			grades[3]++;
			break;
		case "B+":
			grades[4]++;
			break;
		case "C":
			grades[5]++;
			break;
		case "C+":
			grades[6]++;
			break;
		case "D":
			grades[7]++;
			break;
		case "D+":
			grades[8]++;
			break;
		case "F":
			grades[9]++;
			break;
		case "I":
			grades[10]++;
			break;
		case "W":
			grades[11]++;
			break;
		}
	}
}
