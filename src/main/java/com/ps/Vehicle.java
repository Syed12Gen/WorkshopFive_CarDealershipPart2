package com.ps;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;
    private double mileage;
    private String type;


    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.mileage = mileage;
        this.type = type;

    }

    // Getters and Setters


    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    public double getMileage() {
        return mileage;
    }

    public String getType() {
        return type;
    }

    // Method to calculate the finance amount after down payment and interest
    public double calculateTotalCost(double downPayment, double interestRate) {
        double financedAmount = this.price - downPayment;
        double totalCost = financedAmount + (financedAmount * interestRate / 100);
        return totalCost;
    }

    @Override
    public String toString() {
        return String.format("| %-6d | %-4d | %-10s | %-15s | %-10s | %-7s | %8d | $%9.2f |",
                vin, year, make, model, vehicleType, color, odometer, price);
    }
}