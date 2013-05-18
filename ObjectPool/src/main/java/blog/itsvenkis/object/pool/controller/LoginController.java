package blog.itsvenkis.object.pool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import blog.itsvenkis.object.pool.User;
import blog.itsvenkis.object.pool.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	//provides a handle to User objects.
	private UserService userSrvc;
	
	public UserService getUserSrvc() {
		return userSrvc;
	}

	public void setUserSrvc(UserService userSrvc) {
		this.userSrvc = userSrvc;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String greetLogInPage(@ModelAttribute(value="user") User user,
			Model model,
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws Exception {
		model.addAttribute("userName", user.getUserName());
		return "greetings";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String login(Model model) throws Exception{
		//Get the user object from pool
		User user = userSrvc.newUser();
		model.addAttribute("user",user);
		return "login";
	}
	
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String logOutUser(@ModelAttribute(value="user") User user) throws Exception{
		/*
		 * We no longer need this user object return it back to the pool. 
		 * so that it can be reused 
		 */
		userSrvc.returnUser(user);
		return "logout";
	}
	
}
