package com.antra1;

public final class School {
	
	private final int schoolId;
	private final String schoolName;
	
	public School(int schoolId, String schoolName) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
	}

	public Object modify(int id,String name) {
		
		return new School(id, name);
		
	}
	public int getSchoolId() {
		return schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}
	
}
