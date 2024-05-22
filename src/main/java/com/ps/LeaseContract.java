package com.ps;

public class LeaseContract extends Contract{
    private double leasePrice;
    private double endOfLeasePurchasePrice;

    public LeaseContract (String dateOfContract, String customerName, String customerEmail, Vehicle vehicle, double leasePrice, double endOfLeasePurchasePrice) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.leasePrice = leasePrice;
        this.endOfLeasePurchasePrice = endOfLeasePurchasePrice;
    }

    public double getLeasePrice(){
        return leasePrice;
    }

    public void setLeasePrice(double leasePrice) {
        this.leasePrice = leasePrice;
    }


    public double getEndOfLeasePurchasePrice(){
        return  endOfLeasePurchasePrice;
    }

    public void setEndOfLeasePurchasePrice(double endOfLeasePurchasePrice) {
        this.endOfLeasePurchasePrice = endOfLeasePurchasePrice;
    }

    @Override
    public double getTotalPrice() {
        return leasePrice;
    }

    @Override
    public double getMonthlyPayment() {
        return leasePrice / 36;
    }
}
