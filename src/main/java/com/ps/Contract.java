package com.ps;

public abstract class Contract {
    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String dateOfContract, String customerEmail, String customerName, Vehicle vehicle) {
        this.dateOfContract = dateOfContract;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

}

