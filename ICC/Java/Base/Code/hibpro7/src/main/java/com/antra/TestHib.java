package com.antra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class TestHib {
	
	static EntityManagerFactory EMF=Persistence.createEntityManagerFactory("mysql");

	
	public static void main(String[] args) {
		
		//NativeSQLEx();
		//HQLEx();
		//fetchTypeEx();
		//oneTomanyEx();
		//oneTooneEx();
		//generatorEx();
		insertEmployee();
		//getEmployee();
		//updateEmployee();
		EMF.close();
	}


	private static void NativeSQLEx() {
		EntityManager em=EMF.createEntityManager();
		
		Query query=em.createNativeQuery("select * from Employee");
		List<Employee> li=query.getResultList();	
		for(Employee e:li)
		System.out.println(e.getEmpName());
		em.close();
	}


	private static void HQLEx() {
		EntityManager em=EMF.createEntityManager();
		Query query=em.createQuery("from Employee e where empId=:id");
		query.setParameter("id", 2);
		List<Employee> li=query.getResultList();	
		for(Employee e:li)
		System.out.println(e.getEmpName());
		em.close();
	}


	private static void fetchTypeEx() {
		
		EntityManager em=EMF.createEntityManager();
		Student st=em.find(Student.class, 1);
		
		em.close();
		System.out.println(st.getStudentName());
		System.out.println(st.getLaptopList());
	}


	private static void oneTomanyEx() {
		EntityManager em=EMF.createEntityManager();
		em.getTransaction().begin();
		
		Student st=new Student();
		st.setStudentName("Manas");
		
		Laptop laptop1=new Laptop();
		laptop1.setLaptopName("Dell");
		
		Laptop laptop2=new Laptop();
		laptop2.setLaptopName("Samsung");
		
		List<Laptop> li=st.getLaptopList();
		li.add(laptop1);
		li.add(laptop2);
		
		st.setLaptopList(li);
		em.persist(st);
		em.getTransaction().commit();
		em.close();
		
	}


	private static void oneTooneEx() {
		EntityManager em=EMF.createEntityManager();
		em.getTransaction().begin();
		
		Person p=new Person();
		p.setPersonName("Mert");
		
		Address adr=new Address();
		adr.setCity("NewYork");
		adr.setStreet("131/21");
		
		p.setAdr(adr);
		
		
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		
	}


	private static void generatorEx() {

		EntityManager em=EMF.createEntityManager();
		em.getTransaction().begin();
		
		Person p=new Person();
		p.setPersonName("Jerry");
		
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		
	}


	private static void updateEmployee() {
		EntityManager em=EMF.createEntityManager();
		Employee emp=em.find(Employee.class, 1);
				emp.setEmpSal(000);
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
		
		
	}


	private static void getEmployee() {
		EntityManager em=EMF.createEntityManager();
		
		Employee emp=em.find(Employee.class, 1);
		
		System.out.println(emp.getEmpId());
		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpSal());
		em.close();
		
		
	}


	public static void insertEmployee() {
		
		EntityManager em=EMF.createEntityManager();
		em.getTransaction().begin();
		
		Employee emp1=new Employee();
		emp1.setEmpId(3);
		emp1.setEmpName("David");
		emp1.setEmpSal(876);
		
		Employee emp2=new Employee();
		emp2.setEmpId(4);
		emp2.setEmpName("Naveen");
		emp2.setEmpSal(945);
		
		em.persist(emp1);
		em.persist(emp2);
		em.getTransaction().commit();
		em.close();
		
		
	}
}
