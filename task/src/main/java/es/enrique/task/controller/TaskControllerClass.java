package es.enrique.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.enrique.task.model.Priority;
import es.enrique.task.model.Status;
import es.enrique.task.model.Task;
import es.enrique.task.service.PriorityService;
import es.enrique.task.service.StatusService;
import es.enrique.task.service.TaskService;
import es.enrique.task.service.UserService;



@Controller("taskControllerClass")
@SessionAttributes("userInSession")
public class TaskControllerClass {

	@Autowired 
	@Qualifier("userService")
	UserService userService;
	
	@Autowired 
	@Qualifier("priorityService")
	PriorityService priorityService;
	
	@Autowired 
	@Qualifier("statusService")
	StatusService statusService;
	
	@Autowired 
	@Qualifier("taskService")
	TaskService taskService;
	
	@Autowired 
	List<Priority> priorityList;
	
	@Autowired 
	List<Status> statusList;

	@GetMapping(path = "/addTask")
	public ModelAndView indexPage() {
		priorityList = priorityService.selectAllPriorityList();
		statusList = statusService.selectAllStatusList();
		ModelAndView model = new ModelAndView("addTask");
		model.addObject("task", new Task());
		model.addObject("priority", new Priority());
		model.addObject("status", new Status());
		model.addObject("PriorityList", priorityList);
		model.addObject("StatusList", statusList);
		return model;
	}
	
	@PostMapping(path="/addTask")
	public String addTask(Task task, Priority priority, Status status)  {
		taskService.addTask(task, priority, status);
		return "userMenu";
	}
}

