package main.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "classes")
public class Course implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String time;
	private String day;
	@Column(name="max_capacity")
	private int capacity;

	@ManyToOne()
	@JoinColumn(name="professor_id", referencedColumnName = "id", insertable = false, updatable = false) 
	private Professor professor;
	
	private int professor_id;
	
	
	@ManyToOne()
	@JoinColumn(name="subject_id", referencedColumnName = "id", insertable = false, updatable = false)  
	private Subject subject;
	
	private int subject_id;
	
	@ManyToMany
	@JoinTable(name="course_to_student",
				joinColumns=@JoinColumn(name="course_id"),
				inverseJoinColumns=@JoinColumn(name="student_id"))
	private Set<Student> students;

	public Course() {
		this.professor = new Professor();
		this.subject = new Subject();
		this.students = new HashSet();
	}
	
	/**
	 * @param id
	 * @param code
	 * @param time
	 * @param day
	 * @param capacity
	 */
	public Course(int id, String code, String time, String day, int capacity) {
		this.id = id;
		this.code = code;
		this.time = time;
		this.day = day;
		this.capacity = capacity;
	}
	
	public void setProfessorId() {
		this.professor_id=this.professor.getId();
	}
	
	public void setSubjectId() {
		this.subject_id=this.subject.getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}



	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

