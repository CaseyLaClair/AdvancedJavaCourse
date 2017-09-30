/**
 * @author Casey LaClair
 * 29 Sept, 2017
 * This class tests the function of the Rating and Movie classes.
 */
public class MovieTest {

	public static void main(String[] args) {
		
		//First movie created
		Rating m1viewer = new Rating(35304, 26125);
		Rating m1critic = new Rating(48, 45);
		Movie m1 = new Movie("Invasion of the Body Snatchers", 1978, m1viewer, m1critic);
		System.out.println(m1.toString());
		
		//Second movie created
		Rating m2viewer = new Rating(9492, 8638);
		Rating m2critic = new Rating(22, 20);
		Movie m2 = new Movie("Inherit the Wind", 1960, m2viewer, m2critic);
		System.out.println(m2.toString());
		
		//Third movie created
		Rating m3viewer = new Rating(128955, 94137);
		Rating m3critic = new Rating(143, 120);
		Movie m3 = new Movie("Erin Brockovich", 2000, m3viewer, m3critic);
		System.out.println(m3.toString());
		
	}

}
