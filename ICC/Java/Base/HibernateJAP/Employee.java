

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GenericGenerator(strategy="increment",name="inc")
	@GeneratedValue(generator="inc")
	@Column(name="employee_id")
	Integer empId;
	
	@Column(name="employee_name")
	String empName;
	
	@Column(name="employee_sal")
	Integer empSal;
	
	
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Integer empSal) {
		this.empSal = empSal;
	}

	
	
}
