import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class TestHib {
	static EntityManagerFactory EMF=Persistence.createEntityManagerFactory("mysql");

	
	public static void main(String[] args) {
	
	
		//many to many (will create middle table automatically)
		//need set inverseJoinColumns
		//generatorReader();
		
		//many to one (no middle table)
		//generatorTeacher();
		
		//one to many(will create middle table automatically)
		//generatorStd();
		
		//test cascade
		//deletePerson();//both person and address will be deleted
		//deleteAddress();//Cannot delete or update a parent row: a foreign key constraint fails
		
		
		//deleteEmployee();
		//updateEmployee();
		
		//NativeSQLEx();
		//HQLEx();
		//fetchTypeEx();
		//oneTomanyEx();
		//oneTooneEx();
		//generatorEx();
		//insertEmployee();
		//getEmployee();
		//updateEmployee();
		EMF.close();
	}
private static void generatorReader() {
		//https://howtodoinjava.com/hibernate/hibernate-many-to-many-mapping/
		EntityManager em=EMF.createEntityManager();
		em.getTransaction().begin();
		 //Add subscription
        SubscriptionEntity subOne = new SubscriptionEntity();
        subOne.subscriptionName= "Entertainment";
         
        SubscriptionEntity subTwo = new SubscriptionEntity();
        subTwo.subscriptionName= "Horror";
         
        Set<SubscriptionEntity> subs = new HashSet<SubscriptionEntity>();
        subs.add(subOne);
        subs.add(subTwo);
         
        //Add readers
        ReaderEntity readerOne = new ReaderEntity();
        readerOne.email = "demo-user1@mail.com";
        readerOne.firstName = "demo";
        readerOne.lastName = "user";
         
        ReaderEntity readerTwo = new ReaderEntity();
        readerTwo.email = "demo-user2@mail.com";
        readerTwo.firstName = "demo";
        readerTwo.lastName = "user";
         
        Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
        readers.add(readerOne);
        readers.add(readerTwo);
         
        readerOne.subscriptions =  subs;
        readerTwo.subscriptions = subs;
 
        em.persist(readerOne);
        em.persist(readerTwo);
		
		
		em.getTransaction().commit();
		em.close();
	}
	private static void generatorTeacher() {
		EntityManager em=EMF.createEntityManager();
		em.getTransaction().begin();
		
		
		Teacher teacher = new Teacher("Davis");
		Course c1 = new Course("Math",teacher);
		Course c2 = new Course("English",teacher);
		Set<Course> courses =new HashSet<Course>(Arrays.asList(c1,c2));
		
		teacher.courses = courses;

		System.out.println(teacher.courses);
		em.persist(c1);
		em.persist(c2);	
		em.persist(teacher);
		em.getTransaction().commit();
		em.close();
	}
	private static void generatorStd() {
		EntityManager em=EMF.createEntityManager();
		em.getTransaction().begin();
		
		Student s=new Student();
		s.setStudentName("Howard");
		
		java.util.List<Laptop> laptopList = Arrays.asList(new Laptop("mac"),new Laptop("HP"));
		s.setLaptopList(laptopList);
		System.out.println(laptopList);
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	private static void deleteEmployee() {
		EntityManager em=EMF.createEntityManager();
		Employee emp=em.find(Employee.class, 3);
		  if (em.contains(emp)) {
			  em.getTransaction().begin();
			  em.remove(emp);
			  em.getTransaction().commit();
		  }
		em.close();		
	}
	private static void deleteAddress() {
		EntityManager em=EMF.createEntityManager();
		Address ad=em.find(Address.class, 3);
		  if (em.contains(ad)) {
			  em.getTransaction().begin();
			  em.remove(ad);
			  em.getTransaction().commit();
		  }
		em.close();		
	}
	private static void deletePerson() {
		EntityManager em=EMF.createEntityManager();
		Person p=em.find(Person.class, 3);
		  if (em.contains(p)) {
			  em.getTransaction().begin();
			  em.remove(p);
			  em.getTransaction().commit();
		  }
		em.close();		
	}

	//===

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
		//fetch=FetchType.LAZY (Laptop only load when you read)
		//only load wh
		em.close();
		//fetch=FetchType.EAGER (Laptop loaded)
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
