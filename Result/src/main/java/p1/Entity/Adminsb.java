package p1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Adminsb 
{

	
		@Id
		@Column(length=20)
		private String email;
		@Column(length=10)
		private String name;
		@Column(length=15)
		private String password;
		
}
