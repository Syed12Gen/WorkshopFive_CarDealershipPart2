package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;


    // Constructors
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                filteredVehicles.add(v);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                filteredVehicles.add(v);
            }
        }
        return filteredVehicles;
    }

}