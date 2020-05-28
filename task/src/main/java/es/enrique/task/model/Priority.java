package es.enrique.task.model;

import org.springframework.stereotype.Component;

@Component
public class Priority {
	private int idPriority;
	private String priorityName;
	
	public int getIdPriority() {
		return idPriority;
	}
	public void setIdPriority(int idPriority) {
		this.idPriority = idPriority;
	}
	public String getPriorityName() {
		return priorityName;
	}
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	
	
}
