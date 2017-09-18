package ru.itis.inform.Build;

public class TestCar {
    private static Car car;

    public static void main(String[] args) {
        car = new Car().newBuilder().setAutomatic(false).setReqion(116).build();
    }
}
