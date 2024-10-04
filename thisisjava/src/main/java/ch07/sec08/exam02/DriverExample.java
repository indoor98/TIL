package ch07.sec08.exam02;

import ch07.sec06.package2.D;

public class DriverExample {
    public static void main(String[] args) {

        Driver driver = new Driver();

        Bus bus = new Bus();
        driver.drive(bus);

        Taxi taxi = new Taxi();
        driver.drive(taxi);
    }
}
