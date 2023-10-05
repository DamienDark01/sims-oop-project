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
public class Teacher {
    
    // properties
    private String id;
    private String firstName;
    private String lastName;
    private Subject subject;
    private String email;
    private String contact;
    private String qualification;
    private String address;
    private char gender;

    // default constructor
    public Teacher() {
        id = null;
        firstName = null;
        lastName = null;
        subject = null;
        email = null;
        contact = null;
        qualification = null;
        address = null;
        gender = 0;
    }

    // overloaded constructor
    public Teacher(String id, String firstName, String lastName, Subject subject, String email, String contact, String qualification, String address, char gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
		this.email = email;
		this.contact = contact;
		this.qualification = qualification;
		this.address = address;
		this.gender = gender;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

}