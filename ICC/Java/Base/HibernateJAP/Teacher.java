

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GenericGenerator(strategy="increment", name="inc")
	@GeneratedValue(generator="inc")
	@Column(name = "teacher_id")
	Integer seqId;
	@Column(name = "name",length=150, nullable=false)
	String name;
	@OneToMany(mappedBy="teacher")
	Set<Course> courses;
	public Teacher() {}
	public Teacher(String name) {
		this.name = name;
	}
	
	
	
}
