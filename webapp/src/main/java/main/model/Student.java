/**
 * 
 */
package main.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    /*
	@OneToMany(mappedBy="subject", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Course> courses;
	*/
    
    public Student() {
    	
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




	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}

