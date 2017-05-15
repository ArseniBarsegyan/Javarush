package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        return isSummer(date, SummerStart, SummerEnd) ? getSummerConsumption(length) : getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) {
            return numberOfPassengers;
        }
        return 0;
    }

    private boolean canPassengersBeTransferred() {
        return  (isDriverAvailable() && fuel > 0);
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {
        Car car = new Truck(numberOfPassengers);
        if (type == 0) {
            car = new Truck(numberOfPassengers);
        } else if (type == 1) {
            car = new Sedan(numberOfPassengers);
        } else if (type == 2) {
            car = new Cabriolet(numberOfPassengers);
        }
        return car;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        return (date.before(summerEnd) && date.after(summerStart));
    }

    public double getSummerConsumption(int length) {
        return summerFuelConsumption * length;
    }

    public double getWinterConsumption(int length) {
        return winterFuelConsumption * length + winterWarmingUp;
    }

}