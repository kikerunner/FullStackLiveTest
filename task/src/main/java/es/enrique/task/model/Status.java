package es.enrique.task.model;

import org.springframework.stereotype.Component;

@Component
public class Status {
	private int idStatus;
	private String statusName;
	
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
