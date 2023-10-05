/*
 * Classname : Examination
 * Entity class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// imports

public class Examination {
    
    // properties
    private String id;
    private String subId;
    private String examType;
    private String duration;

    // default constructor
    public Examination() {
        id = null;
        subId = null;
        examType = null;
        duration = null;
    }

    // overloaded constructor
    public Examination(String id, String subId, String examType, String duration) {
		super();
		this.id = id;
		this.subId = subId;
		this.examType = examType;
		this.duration = duration;
	}

    // getters and setters
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}