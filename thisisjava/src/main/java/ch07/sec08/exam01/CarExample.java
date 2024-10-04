package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.tire = new HanKookTire();
        myCar.run();

        myCar.tire = new KumhoTire();
        myCar.run();
    }
}
