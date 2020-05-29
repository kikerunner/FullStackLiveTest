package es.enrique.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.enrique.task.model.Status;
import es.enrique.task.repository.RespositoryStatus;

@Service("statusService")
public class StatusService {
	@Autowired
	@Qualifier("repositoryStatus")
	private RespositoryStatus repositoryStatus;
	
	public List<Status> selectAllStatusList() {
		return repositoryStatus.selectAllStatusList();
	}
}
