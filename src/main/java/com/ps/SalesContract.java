package com.ps;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;
    private double monthlyPayment;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, int vehicle) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    public double getSaleTaxAmount() {
        return salesTaxAmount;
    }

    public void setSaleTaxAmount(double saleTaxAmount) {
        this.salesTaxAmount = saleTaxAmount;
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

    @Override
    public double getTotalPrice() {
        return Double.parseDouble(null);
    }

    @Override
    public double getMonthlyPayment() {
    return Double.parseDouble(null);
    }
}
