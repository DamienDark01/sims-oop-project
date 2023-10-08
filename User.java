/*
 * Class Name : User
 * Entity class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// package
package project;

// imports

// class implementation
class User {

    // properties
    private String id;
    private String name;
	private String password;
    private String accountType;
    private String email;
    private String contact;
    private String address;
    private String gender;

    // default constructor
    public User() {
        id = null;
        name = null;
		password = null;
        accountType = null;
        email = null;
        contact = null;
        address = null;
        gender = null;
    }

    // overloaded constructor
    public User(String id, String name, String password, String accountType, String email, String contact, String address, String gender) {
        this.id = id;
        this.name = name;
		this.password = password;
        this.accountType = accountType;
        this.email = email;
        this.contact = contact;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}