package net.antra.design.observer;

import java.util.Observable;
import java.util.Observer;

public class ProductPriceCheck implements Observer {

	public ProductPriceCheck() { }

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Price Check run");
	}
}
