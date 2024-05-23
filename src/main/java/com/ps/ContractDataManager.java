package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ContractDataManager {
    private List<Contract> contracts;

    public ContractDataManager() {
        this.contracts = new ArrayList<>();
    }

    public void saveContract(Contract contract) {
        contracts.add(contract);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DB_Dealership.csv", true))) {
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                writer.write(String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%b|%.2f\n",
                        salesContract.getDateOfContract(),
                        salesContract.getCustomerName(),
                        salesContract.getCustomerEmail(),
                        salesContract.getVehicle().getVin(),
                        salesContract.getVehicle().getYear(),
                        salesContract.getVehicle().getMake(),
                        salesContract.getVehicle().getModel(),
                        salesContract.getVehicle().getVehicleType(),
                        salesContract.getVehicle().getColor(),
                        salesContract.getVehicle().getOdometer(),
                        salesContract.getVehicle().getPrice(),
                        salesContract.getTotalPrice(),
                        salesContract.getSalesTaxAmount(),
                        salesContract.getRecordingFee(),
                        salesContract.getProcessingFee(),
                        salesContract.isFinanceOption() + "\n",
                        salesContract.getMonthlyPayment()));
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                writer.write(String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f\n",
                        leaseContract.getDateOfContract(),
                        leaseContract.getCustomerName(),
                        leaseContract.getCustomerEmail(),
                        leaseContract.getVehicle().getVin(),
                        leaseContract.getVehicle().getYear(),
                        leaseContract.getVehicle().getMake(),
                        leaseContract.getVehicle().getModel(),
                        leaseContract.getVehicle().getVehicleType(),
                        leaseContract.getVehicle().getColor(),
                        leaseContract.getVehicle().getOdometer(),
                        leaseContract.getVehicle().getPrice(),
                        leaseContract.getLeasePrice(),
                        leaseContract.getEndOfLeasePurchasePrice(),
                        leaseContract.getTotalPrice(),
                        leaseContract.getMonthlyPayment()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

