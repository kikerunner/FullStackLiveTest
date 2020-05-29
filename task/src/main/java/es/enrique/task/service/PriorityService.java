package es.enrique.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.enrique.task.model.Priority;
import es.enrique.task.model.Task;
import es.enrique.task.model.User;
import es.enrique.task.repository.RespositoryPriority;
import es.enrique.task.repository.RespositoryTask;

@Service("priorityService")
public class PriorityService {
	@Autowired
	@Qualifier("repositoryPriority")
	private RespositoryPriority repositoryPriority;
	
	public List<Priority> selectAllPriorityList() {
		return repositoryPriority.selectAllPriorityList();
	}
}
