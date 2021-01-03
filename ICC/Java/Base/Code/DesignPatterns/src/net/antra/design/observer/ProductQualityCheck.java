package net.antra.design.observer;

import java.util.Observable;
import java.util.Observer;

public class ProductQualityCheck implements Observer {

	public ProductQualityCheck() {

	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Quality Check run");
	}
}
