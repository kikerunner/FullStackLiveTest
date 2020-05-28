package es.enrique.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.enrique.task.model.Task;
import es.enrique.task.model.User;
import es.enrique.task.service.TaskService;


@Controller("userMenuControllerClass")
@SessionAttributes("userInSession")
public class UserMenuControllerClass {
	
	@Autowired 
	List<Task> todoTaskList;
	
	@Autowired 
	List<Task> inProgressTaskList;
	
	@Autowired 
	List<Task> doneTaskList;
	
	@Autowired 
	@Qualifier("taskService")
	TaskService taskService;
	
	@GetMapping(path = "/LoadToDoTaskList")
	public ModelAndView loadToDoTaskList() {
		todoTaskList = taskService.selectAllToDoTaskList();
		ModelAndView model = new ModelAndView("todoList");
		model.addObject("todoTaskList", todoTaskList);
		return model;
	}
	
	@GetMapping(path = "/LoadInProgressTaskList")
	public ModelAndView loadInProgressTaskList() {
		inProgressTaskList = taskService.selectAllInProgressTaskList();
		ModelAndView model = new ModelAndView("inProgressList");
		model.addObject("inProgressTaskList", inProgressTaskList);
		return model;
	}
	
	@GetMapping(path = "/LoadDoneTaskList")
	public ModelAndView loadDoneTaskList() {
		doneTaskList = taskService.selectAllDoneTaskList();
		ModelAndView model = new ModelAndView("doneList");
		model.addObject("doneTaskList", doneTaskList);
		return model;
	}
}
