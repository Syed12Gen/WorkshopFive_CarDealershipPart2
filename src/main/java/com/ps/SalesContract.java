package com.ps;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;
    private double monthlyPayment;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }


    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = getVehicle().getPrice();
        double salesTaxAmount = vehiclePrice * 0.05;
        double recordingFee = 100;
        double processingFee = vehiclePrice < 10000 ? 295 : 495;
        return vehiclePrice + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financeOption) {
            return 0;
        }

        double loanAmount = getTotalPrice();
        double interestRate;
        int term;

        if (loanAmount >= 10000) {
            interestRate = 0.0425;
            term = 48;
        } else {
            interestRate = 0.0525;
            term = 24;
        }

        double monthlyInterestRate = interestRate / 12;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -term));
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

}
