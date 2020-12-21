package com.antra1;

public class Fruit {

	private int fruitId;
	private String fruitName;
	
	
	public Fruit(int fruitId, String fruitName) {
		
		this.fruitId = fruitId;
		this.fruitName = fruitName;
	}


	@Override
	public String toString() {
		return "fruitId=" + fruitId + ", fruitName=" + fruitName ;
	}
	
	public boolean equals(Object obj) {
		
		Fruit f2=(Fruit)obj;
		if(this.fruitId==f2.fruitId && this.fruitName.equals(f2.fruitName)) {
			return true;
		}
		return false;
	}
	
	/*public String toString() {
		
		return getClass().getName()+"@"+Integer.toHexString(hashCode());
	}*/
	
	
	/*
	public int getFruitId() {
		return fruitId;
	}
	public void setFruitId(int fruitId) {
		this.fruitId = fruitId;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}*/
	
	
}
