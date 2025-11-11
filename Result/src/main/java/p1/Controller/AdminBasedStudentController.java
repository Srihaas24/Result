package p1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p1.Entity.Student;
import p1.Repo.StudentRepo;

@Controller
public class AdminBasedStudentController 
{
	@Autowired
	private StudentRepo sr;
	
	@PostMapping("/addStu")
	public String addStudent(@RequestParam("stu_id") String roll_no, @RequestParam("name") String name, @RequestParam("m_name") String mname, @RequestParam("f_name") String fname, @RequestParam("dob") String dob) 
	{
		Student s = new Student();
		s.setRollno(roll_no);
		s.setDob(dob);
		s.setName(name);
		s.setF_name(fname);
		s.setM_name(fname);
		sr.save(s);
		
		return "success";
	}

	@PostMapping("/editStu")
	public String editStudent(@RequestParam("stu_id") String roll_no, @RequestParam("name") String name, @RequestParam("m_name") String mname, @RequestParam("f_name") String fname, @RequestParam("dob") String dob) 
	{
		Student s = new Student();
		s.setRollno(roll_no);
		s.setDob(dob);
		s.setName(name);
		s.setF_name(fname);
		s.setM_name(fname);
		sr.save(s);
		
		return "success";
	}
	
	@PostMapping("/deleteStu")
	public String deleteStudent(@RequestParam("stu_id") String roll_no) 
	{
		sr.deleteById(roll_no);
		
		return "success";
	}
}
