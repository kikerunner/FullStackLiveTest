package es.enrique.task.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Task {
	
	@Autowired
	Priority priority;
	
	@Autowired
	Status status;
	
	private int idTask;
	private String name;
	private String description;
	private Date deadLine;
	
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getIdTask() {
		return idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
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
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
}
