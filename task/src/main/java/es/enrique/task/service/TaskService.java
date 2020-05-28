package es.enrique.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.enrique.task.model.Task;
import es.enrique.task.model.User;
import es.enrique.task.repository.RespositoryTask;

@Service("taskService")
public class TaskService {
	@Autowired
	@Qualifier("repositoryTask")
	private RespositoryTask repositoryTask;
	
	public List<Task> selectAllToDoTaskList() {
		return repositoryTask.selectAllTodoTaskList();
	}
	
	public List<Task> selectAllInProgressTaskList() {
		return repositoryTask.selectAllInProgressList();
	}
	
	public List<Task> selectAllDoneTaskList() {
		return repositoryTask.selectAllDoneList();
	}
}
