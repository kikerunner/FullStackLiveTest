package es.enrique.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView loadToDoTaskList(@ModelAttribute("userInSession") User userLoad) {
		todoTaskList = taskService.selectAllToDoTaskList(userLoad.getIdUser());
		ModelAndView model = new ModelAndView("todoList");
		model.addObject("todoTaskList", todoTaskList);		
		return model;
	}
	
	@GetMapping(path = "/LoadInProgressTaskList")
	public ModelAndView loadInProgressTaskList(@ModelAttribute("userInSession") User userLoad) {
		inProgressTaskList = taskService.selectAllInProgressTaskList(userLoad.getIdUser());
		ModelAndView model = new ModelAndView("inProgressList");
		model.addObject("inProgressTaskList", inProgressTaskList);
		return model;
	}
	
	@GetMapping(path = "/LoadDoneTaskList")
	public ModelAndView loadDoneTaskList(@ModelAttribute("userInSession") User userLoad) {
		doneTaskList = taskService.selectAllDoneTaskList(userLoad.getIdUser());
		ModelAndView model = new ModelAndView("doneList");
		model.addObject("doneTaskList", doneTaskList);
		return model;
	}
	
	@GetMapping(path = "/userMenu")
	public ModelAndView indexPage() {
		ModelAndView model = new ModelAndView("userMenu");
		return model;
	}
}
