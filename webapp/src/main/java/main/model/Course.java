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
	private String classId;
	private String subjectId;
	private int roomId;
	private int timeCode;
	private int dayCode;
	private boolean isFull;
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
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
	public boolean isFull() {
		return isFull;
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	
}

