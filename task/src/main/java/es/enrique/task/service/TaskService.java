package es.enrique.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.enrique.task.model.Priority;
import es.enrique.task.model.Status;
import es.enrique.task.model.Task;
import es.enrique.task.model.User;
import es.enrique.task.repository.RespositoryTask;

@Service("taskService")
public class TaskService {
	@Autowired
	@Qualifier("repositoryTask")
	private RespositoryTask repositoryTask;
	
	public List<Task> selectAllToDoTaskList(int userLoadID) {
		return repositoryTask.selectAllTodoTaskList(userLoadID);
	}
	
	public List<Task> selectAllInProgressTaskList(int userLoadID) {
		return repositoryTask.selectAllInProgressList(userLoadID);
	}
	
	public List<Task> selectAllDoneTaskList(int userLoadID) {
		return repositoryTask.selectAllDoneList(userLoadID);
	}
	
	public void addTask(Task task, Priority priority, Status status) {
		repositoryTask.insertTask(task, priority, status);
	}
}
