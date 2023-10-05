/*
 * Classname : Laboratory
 * Entity class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// imports

// class implementation
public class Student {

    // properties
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    private String email;
    private char gender;
    private String classId;

    // default constructor
    public Student() {
        id = null;
        firstName = null;
        lastName = null;
        address = null;
        contact = null;
        email = null;
        gender = 0;
        classId = null;
    }

    // overloaded constructor
    public Student(String id, String firstName, String lastName, String address, String contact, String email,
			char gender, String classId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.classId = classId;
	}

    // getters and setters
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
    
}