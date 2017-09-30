/**
 * @author Casey LaClair
 * 29 Sept, 2017
 * This class creates a movie object.
 */

public class Movie {

	//All fields needed to create a movie.
	private String title;
	private int releaseYear;
	private Rating viewerRating;
	private Rating criticRating;
	
	/**
	 * This constructor creates a movie with the following parameters.
	 * @param title - The title of the movie
	 * @param releaseYear - Year the movie was released
	 * @param viewerRating - Ratings from viewers
	 * @param criticRating - Ratings from critics
	 */
	public Movie(String title, int releaseYear, Rating viewerRating, Rating criticRating) {
		
		//Declare each variable of the object created.
		this.title = title;
		this.releaseYear = releaseYear;
		this.viewerRating = new Rating(viewerRating);
		this.criticRating = new Rating(criticRating);
		
	}
	
	/**
	 * Replaces toString method with specified version.
	 * @return Formatted String of all movie data
	 */
	public String toString() {
		
		String values = String.format("Title: %s\nRelease Year: %d\nRating:\n\tViewer: %s\n\tCritic: %s\n", 
					title, releaseYear, viewerRating.toString(), criticRating.toString());
		
		return values;
	}
}
