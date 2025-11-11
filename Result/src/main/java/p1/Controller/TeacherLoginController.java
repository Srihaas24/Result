package p1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p1.Entity.Teacher;
import p1.Repo.TeacherRepo;

@Controller
public class TeacherLoginController 
{
	@Autowired
	private TeacherRepo tr;
	
	@GetMapping("/teacherlogin")
	public String teacherlogin()
	{
		return "teacher-login";
	}
	
	@PostMapping("/validateTeacher")
	public String validateTeacher(@RequestParam("id") String id, @RequestParam("password") String password, Model model)
	{
		List<Teacher> l = tr.findByIdAndPassword(id, password);
		
		if(l.size()==1)
		{
			model.addAttribute("tname",l.get(0).getName());
			return "welcome-teacher";
		}
		return "not-found";
	}
}
