package p1.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Data
@Entity
public class Teacher 
{
	@Id
	@Column(length=5)
	private String id;
	@Column(length=10)
	private String name;
	@Column(length=10)
	private String password;
}
