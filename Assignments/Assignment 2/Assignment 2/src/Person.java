
public class Person {
	
	//Fields:
	private String name;		//the person's name
	private String address;		//the person's address
	private String telephone;	//the person's telephone number
	
	//Methods:
	//CONSTRUCTORS
	/**
	 * Person, no-arg constructor
	 * Initialize all fields to the empty string
	 */
	public Person() {
		name="";
		address="";
		telephone="";
	}
	
	/**
	 * Person, constructor that takes arguments for all fields
	 * @param name -- String, value to put in the name field
	 * @param address -- String, value to put in the address field
	 * @param telephone -- String, value to put in the telephone field
	 */
	public Person(String name, String address, String telephone){
		this.name=name;
		this.address=address;
		this.telephone=telephone;
	}
	
	/**
	 * Person, copy constructor
	 * @param toClone -- a Person object to copy into the current object
	 */
	public Person(Person toClone){
		this.name=toClone.name;
		this.address=toClone.address;
		this.telephone=toClone.telephone;
	}
	
	//ACCESSORS
	
	/**
	 * getName, name field accessor
	 * @return value in the name field, String
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * getAddress, address field accessor
	 * @return value in the address field, String
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * getTelephone, telephone field accessor
	 * @return value in the telephone field, String
	 */
	public String getTelephone(){
		return telephone;
	}
	
	//MUTATORS
	
	/**
	 * setName, name field mutator
	 * @param name -- String, value to put in the name field
	 */
	public void setName(String name){
		this.name=name;
	}
	
	/**
	 * setAddress, address field mutator
	 * @param address -- String, value to put in the address field
	 */
	public void setAddress(String address){
		this.address=address;
	}
	
	/**
	 * setTelephone, telephone field mutator
	 * @param telephone -- String, value to put in the telephone field
	 */
	public void setTelephone(String telephone){
		this.telephone=telephone;
	}
	
	//OTHER METHODS
	
	/**
	 * toString, return a String representing the fields of the object.
	 */
	public String toString(){
		String str="Name: "+name+"\nAddress: "+address+"\nTelephone number: "+telephone;
		return str;
	}
}
