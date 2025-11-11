package p1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p1.Repo.AdminsbRepo;

@Controller
public class AdminLoginController 
{
	
	@Autowired
	private AdminsbRepo ar;
	
	@GetMapping("/adminlogin")
	public String adminlogin()
	{
		return "admin-login";
	}
	
	@PostMapping("/validateAdmin")
	public String vAdmin(@RequestParam("email") String email, @RequestParam("password") String password)
	{
		if(email.equals("srihaas@gmail.com") && password.equals("12345")) return "welcome-admin";
		else return "not-found";
	}
}
