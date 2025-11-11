package p1.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import p1.Entity.Adminsb;

@Repository
public interface AdminsbRepo extends JpaRepository<Adminsb,String> 
{
	List<Adminsb> findByEmailAndPassword(String email, String password);
}
