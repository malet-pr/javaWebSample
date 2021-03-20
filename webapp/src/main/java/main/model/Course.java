package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "classes")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "code")
	private String code;
	private String subjectId;
	private int room;
	private String time;
	private String day;
	private boolean isFull;

	public Course() {}
	
	/**
	 * @param id
	 * @param code
	 * @param subjectId
	 * @param room
	 * @param time
	 * @param day
	 * @param isFull
	 */
	public Course(/*int Id,*/ String code, String subjectId, int room, String time, String day) {
		//this.id = id;
		this.code = code;
		this.subjectId = subjectId;
		this.room = room;
		this.time = time;
		this.day = day;
	}

	/*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	*/

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
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

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
}

