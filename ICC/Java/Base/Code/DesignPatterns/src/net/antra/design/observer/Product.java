package net.antra.design.observer;

import java.util.Observable;

public class Product extends Observable {

	public Product() {
	}

	public void producedSomething() {
		System.out.println("produced somthing");
		this.setChanged();
		this.notifyObservers();
	}

}
