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
public class Laboratory {

    // properties
    private String id;
    private String purpose;
    private String location;
    private String teacherId;

    // default constructor
    public Laboratory() {
        id = null;
        purpose = null;
        location = null;
        teacherId = null;
    }

    // overloaded constructor
    public Laboratory(String id, String purpose, String location, String teacherId) {
		super();
		this.id = id;
		this.purpose = purpose;
		this.location = location;
		this.teacherId = teacherId;
	}

    // getters and setters
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

}