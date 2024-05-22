package com.ps;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    public Dealership getDealership(String filename) {

        Dealership dealership = new Dealership("Default Dealership", "Unknown Address", "N/A");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); // Read the first line for dealership info

            if (line != null) {
                // Splitting the dealership info line
                String[] dealershipInfo = line.split("\\|");
                if (dealershipInfo.length >= 3) {
                    dealership = new Dealership(
                            dealershipInfo[0].trim(), // Name
                            dealershipInfo[1].trim(), // Address
                            dealershipInfo[2].trim()  // Phone
                    );
                }
            }

            // Reading the remaining lines for vehicles
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 8) {
                    try {
                        Vehicle vehicle = new Vehicle(
                                Integer.parseInt(data[0].trim()), // VIN
                                Integer.parseInt(data[1].trim()), // Year
                                data[2].trim(),                    // Make
                                data[3].trim(),                    // Model
                                data[4].trim(),                    // Type
                                data[5].trim(),                    // Color
                                Integer.parseInt(data[6].trim()), // Odometer
                                Double.parseDouble(data[7].trim()) // Price
                        );
                        dealership.addVehicle(vehicle);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing vehicle data: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return dealership;
    }

    // Method to save the dealership data to a file
    public void saveDealership(Dealership dealership, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            // First, write the dealership information
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();

            // Then, write all the vehicles
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor()
                        + "|" + vehicle.getOdometer() + "|" + String.format("%.2f", vehicle.getPrice()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}