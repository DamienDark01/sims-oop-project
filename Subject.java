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
public class Subject {

    // properties
    private String id;
    private String name;
    private int noOfModules;

    // default constructor
    public Subject() {
        id = null;
        name = null;
        noOfModules = 0;
    }

    // overloaded constructor
    public Subject(String id, String name, int noOfModules) {
		this.id = id;
		this.name = name;
		this.noOfModules = noOfModules;
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

	public int getNoOfModules() {
		return noOfModules;
	}

	public void setNoOfModules(int noOfModules) {
		this.noOfModules = noOfModules;
	}

}