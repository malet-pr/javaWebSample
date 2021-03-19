package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String subjectId;
	private int roomId;
	private int timeCode;
	private int dayCode;
	
	public Course() {}
	
	/**
	 * @param id
	 * @param code
	 * @param subjectId
	 * @param roomId
	 * @param timeCode
	 * @param dayCode
	 */
	public Course(int id, String code, String subjectId, int roomId, int timeCode, int dayCode) {
		this.id = id;
		this.code = code;
		this.subjectId = subjectId;
		this.roomId = roomId;
		this.timeCode = timeCode;
		this.dayCode = dayCode;
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
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getTimeCode() {
		return timeCode;
	}
	public void setTimeCode(int timeCode) {
		this.timeCode = timeCode;
	}
	public int getDayCode() {
		return dayCode;
	}
	public void setDayCode(int dayCode) {
		this.dayCode = dayCode;
	}
}

