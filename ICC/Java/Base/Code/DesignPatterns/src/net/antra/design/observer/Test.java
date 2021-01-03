package net.antra.design.observer;

public class Test {
	public static void main(String[] args) {
		Product p = new Product();
		p.addObserver(new ProductQualityCheck());
		p.addObserver(new ProductPriceCheck());

		p.producedSomething();
	}

}
