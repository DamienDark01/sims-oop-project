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
    private Subject subject;
    private String examType;
    private String duration;

    // default constructor
    public Examination() {
        id = null;
        subject = null;
        examType = null;
        duration = null;
    }

    // overloaded constructor
    public Examination(String id, Subject subject, String examType, String duration) {
		this.id = id;
		this.subject = subject;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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