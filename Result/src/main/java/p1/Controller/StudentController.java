package p1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p1.Entity.Student;
import p1.Repo.StudentRepo;

@Controller
public class StudentController 
{
	@Autowired
	private StudentRepo sr;
	
	@GetMapping("/showStudentsJSON")
	public ResponseEntity<Page<Student>> printStu(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="5") int size )
	{
		Pageable pageable = PageRequest.of(page, size);
		Page<Student> pages = sr.findAll(pageable);
		
		return ResponseEntity.ok(pages);
	}
	
	@GetMapping("/showStudents")
	public String show(
			Model model,
			@RequestParam(defaultValue="0") int page, 
			@RequestParam(defaultValue="2") int size,
			@RequestParam(defaultValue="name") String sortedField,
			@RequestParam(defaultValue="asc") String order,
			@RequestParam(defaultValue="") String keyword)
	{
		Sort sort = order.equalsIgnoreCase(order) ? Sort.by(sortedField).ascending() : Sort.by(sortedField).descending();
		
		Pageable pageable = PageRequest.of(page, size,sort);
		Page<Student> pages;
		if(keyword.isEmpty()) pages = sr.findAll(pageable);
		else pages = sr.findByNameContainingIgnoreCase(keyword, pageable);
		model.addAttribute("stu", pages);
		
		return "show-students";
	}
}
