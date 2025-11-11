package p1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p1.Entity.Student;
import p1.Repo.StudentRepo;

@Controller
public class ResultController 
{
	@Autowired
	private StudentRepo sr;
	
	
	@GetMapping("/checkResult")
	public String checkResult()
	{
		return "check-result";
	}
	
	@PostMapping("/validateResult")
	public String showResult(@RequestParam("rollno") String rollno, @RequestParam("dob") String dob, Model model)
	{
		List<Student> l=sr.findByRollnoAndDob(rollno, dob);
		if(l.size()==1)
		{
			Student s = l.get(0);
			
//			model.addAttribute(s);
			
			model.addAttribute("rollno", s.getRollno());
			model.addAttribute("name", s.getName());
			model.addAttribute("mname", s.getM_name());
			model.addAttribute("fname", s.getF_name());
			model.addAttribute("jmarks", s.getJava_marks());
			model.addAttribute("omarks", s.getOracle_marks());
			model.addAttribute("rmarks",s.getReact_marks());
			if(
					l.get(0).getJava_marks()>=33 &&
					l.get(0).getOracle_marks()>=33&&
					l.get(0).getReact_marks()>=33
					)
			{
				model.addAttribute("status", "Passed");
			}
			else model.addAttribute("status", "Failed");
			return "show-result";
		}
		
		return "student-not found";
	}
	
}
