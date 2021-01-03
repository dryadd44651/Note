


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="course")
public class Course{
	@Id
	@GenericGenerator(strategy="increment", name="inc")
	@GeneratedValue(generator="inc")
	@Column(name = "seq_id")
	Integer seq_id;
	@Column(name = "course_name",length=150, nullable=false)
	String name;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="teacher_id")
	Teacher teacher;
	
	
	public Course() {}
	public Course(String name,Teacher teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	
	
}
