package net.antra.design.builder.lombomDemo;

public class TestCar {
    public static void main(String[] args) {
        Car aCar = Car.builder().frame("iron").make("Toyota").model("Prius").modelYear(2019).build();
        aCar.builder().msrp(100).frame("sdf").model("sdf").build();

        Car.builder().msrp(100).modelYear(100).build();
        System.out.println(aCar);
    }
}
