/**
 * 
 */
package main.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author hp 440
 *
 */

@Entity
@Table(name="students")
public class Student  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@Column(name="national_id")
	private String nationalID;
	@Column(name="student_id")
	private String studentID;
	@Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    
	@ManyToMany
	@JoinTable(name="course_to_student",
				joinColumns=@JoinColumn(name="student_id"),
				inverseJoinColumns=@JoinColumn(name="course_id"))
	private Set<Course> courses;
    
    public Student() {
    	this.courses = new HashSet<>();    	
    }
      
    /**
	 * @param id
	 * @param nationalID
	 * @param studentID
	 * @param firstName
	 * @param lastName
	 */
	public Student(int id, String nationalID, String studentID, String firstName, String lastName) {
		this.id = id;
		this.nationalID = nationalID;
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}

