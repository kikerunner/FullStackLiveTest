package es.enrique.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.enrique.task.model.User;
import es.enrique.task.repository.RepositoryUser;



@Service("userService")
public class UserService {
	@Autowired
	@Qualifier("repositoryUser")
	private RepositoryUser repositoryUser;
	
	public User selectAtLogIn(String userName) {
		return repositoryUser.selectWorkerByID(userName);
	}
}
