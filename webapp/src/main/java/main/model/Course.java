package main.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;


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

	@Embedded
	@ManyToOne()
	@JoinColumn(name="professor_id", referencedColumnName = "id", insertable = false, updatable = false) 
	private Professor professor;
	
	private int professor_id;
	
	@Embedded
	@ManyToOne()
	@JoinColumn(name="subject_id", referencedColumnName = "id", insertable = false, updatable = false)  
	private Subject subject;
	
	private int subject_id;

	public Course() {
		this.professor = new Professor();
		this.subject = new Subject();
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

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

