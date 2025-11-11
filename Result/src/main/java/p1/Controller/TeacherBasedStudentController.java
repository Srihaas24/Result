package p1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p1.Entity.Student;
import p1.Repo.StudentRepo;

@Controller
public class TeacherBasedStudentController 
{
	@Autowired
	private StudentRepo sr;
	
	@PostMapping("/findStudent")
	public String findstudent(@RequestParam("rollno") String rollno, Model model, @RequestParam("t_name") String tname)
	{
		List<Student> l = sr.findByRollno(rollno);
		if(l.size()==1)
		{
			model.addAttribute("tname", tname);
			model.addAttribute("rollno",l.get(0).getRollno());
			model.addAttribute("name", l.get(0).getName());
			
			return "add-marks";
		}
		else 
		{
			model.addAttribute("stu","Student is not available");
			return "not-found";
		}
	}
	
	@PostMapping("/submitStudentMarks")
	public String submitmarks(
			@RequestParam("jmarks") String jmarks, 
			@RequestParam("rmarks") String rmarks, 
			@RequestParam("omarks") String omarks, 
			Model model,
			@RequestParam("rollno") String rollno,
			@RequestParam("teach_name") String tname
			)
	{
		List<Student> l=sr.findByRollno(rollno);
		Student s = l.get(0);
		s.setJava_marks(Integer.parseInt(jmarks));
		s.setOracle_marks(Integer.parseInt(omarks));
		s.setReact_marks(Integer.parseInt(rmarks));
		
		sr.save(s);
		model.addAttribute("tname", tname);
		return "welcome-teacher";
	}
}
