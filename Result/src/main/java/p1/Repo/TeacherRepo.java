package p1.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import p1.Entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,String> 
{
	List<Teacher> findByIdAndPassword(String id, String password);
	

}
