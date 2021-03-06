package main.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="professors")
public class Professor  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@NotEmpty(message="this field cannot be empty")
	@Column(name="national_id")
	private String nationalID;
	@NotEmpty(message="this field cannot be empty")
	@Pattern(regexp="^[A-Z]{2}-[0-9]{3}$", message="Employee ID should have the form AZ-123")
	@Column(name="employee_id")
	private String employeeID;
    @Column(name="is_active")
    private boolean isActive;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    
    @Embedded
    @OneToMany(mappedBy="professor", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Course> courses;
    
    public Professor() {
    	this.courses = new HashSet<>();
    }
    
    /**
	 * @param id
	 * @param nationalID
	 * @param employeeID
	 * @param firstName
	 * @param lastName
	 * @param isActive
	 */
	public Professor(int id, String nationalID, String employeeID, boolean isActive, String firstName, String lastName) {
		this.id = id;
		this.nationalID = nationalID;
		this.employeeID = employeeID;
		this.isActive = isActive;
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

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
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
    
}
