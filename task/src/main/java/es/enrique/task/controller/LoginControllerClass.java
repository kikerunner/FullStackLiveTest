package es.enrique.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.enrique.task.model.User;
import es.enrique.task.service.UserService;



@Controller("loginControllerClass")
public class LoginControllerClass {
	
	@Autowired 
	User userLoad;

	@Autowired 
	@Qualifier("userService")
	UserService userService;

	@GetMapping(path = "/login")
	public ModelAndView indexPage() {
		ModelAndView model = new ModelAndView("login");
		model.addObject("user", new User());
		return model;
	}
	@PostMapping(path="/login")
	public ModelAndView startLogginSession(User user)  {	
		userLoad = userService.selectAtLogIn(user.getUserName());
		if(!userLoad.getPassword().equals(user.getPassword())) {
			ModelAndView model = new ModelAndView("login");
			return model;
		}else {
				ModelAndView model = new ModelAndView("userMenu");
				model.addObject("userInSession", userLoad);
				return model;
			}
		}
}

