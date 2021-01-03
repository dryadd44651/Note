package net.antra.design.builder;

public class Test {
	public static void main(String[] args) {

		Department d = Department.builder().setLocation("Here").setManagerName("dawei").build();
		System.out.println(d);
	}
}
