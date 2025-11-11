package p1.Repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import p1.Entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student,String> 
{
	List<Student> findByRollno(String rollno);
	
	Page<Student> findByNameContainingIgnoreCase(String keyword,Pageable pageable);
	
	List<Student> findByRollnoAndDob(String rollno, String dob);
}
