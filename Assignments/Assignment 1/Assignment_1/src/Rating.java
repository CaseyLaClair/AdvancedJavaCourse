/**
 * @author Casey LaClair
 * 29 Sept, 2017
 * This class creates a rating object.
 */
public class Rating {

	//Fields for total and thumbs up ratings.
	private int total;
	private int thumbsUp;
	
	/**
	 * this constructor creates a rating object containing
	 * the total number of reviews and how many were thumbs up.
	 * @param total - Total number of reviews
	 * @param thumbsUp - Number of positive reviews
	 */
	public Rating(int total, int thumbsUp) {
		
		//Declare all variables for the rating object
		this.total = total;
		this.thumbsUp = thumbsUp;
		
	}
	
	/**
	 * This is a copy constructor for a ratings object.
	 * @param toCopy - Rating object to be copied
	 */
	public Rating(Rating toCopy) {
		
		//Copy each field of the object
		total = toCopy.total;
		thumbsUp = toCopy.thumbsUp;
	}
	
	/**
	 * This method calculates the percentage of positive reviews.
	 * @return The percentage of positive reviews.
	 */
	public double getRating() {
		
		double percentage = ((double)thumbsUp/total)*100;
		
		return percentage;
		
	}
	
	/**
	 * Replaces toString method with specified version.
	 * @return Formatted String of all rating data
	 */
	public String toString() {
		
		String values = String.format("Total: %,d; Thumbs-up: %,d; Rating: %.2f%%", total, thumbsUp, getRating());
		
		return values;
	}
}
