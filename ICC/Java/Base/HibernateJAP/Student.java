

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="student")
public class Student {
	@Id
	@GenericGenerator(strategy="increment",name="inc")
	@GeneratedValue(generator="inc")
	@Column(name="student_id")
	Integer studentId;
	
	@Column(name="student_name")
	String studentName;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	List<Laptop> laptopList=new ArrayList(); 
	
	
	
	
	public List<Laptop> getLaptopList() {
		return laptopList;
	}
	public void setLaptopList(List<Laptop> laptopList) {
		this.laptopList = laptopList;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	

}
