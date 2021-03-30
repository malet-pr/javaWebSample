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

@Entity
@Table(name="subjects")
public class Subject  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(length=1000)
    private String description;
    
	@OneToMany(mappedBy="subject", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Course> courses;
    
    public Subject() {
    	this.courses = new HashSet<>();
    }

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param courses
	 */
	public Subject(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public boolean addCourse(Course course) {
		return this.courses.add(course);
	}
	
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
