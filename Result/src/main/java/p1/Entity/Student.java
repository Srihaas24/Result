package p1.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Component
public class Student 
{
	@Id
	@Column(length=8)
	private String rollno;
	@Column(length=10)
	private String name;
	@Column(length=10)
	private String m_name;
	@Column(length=10)
	private String f_name;
	@Column(length=10)
	private String dob;
	@Column(length=3)
	private Integer java_marks;
	@Column(length=3)
	private Integer oracle_marks;
	@Column(length=3)
	private Integer react_marks;

}
