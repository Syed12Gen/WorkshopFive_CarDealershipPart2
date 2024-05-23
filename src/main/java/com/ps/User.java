package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String username;
    private String email;
    private List<Vehicle> purchasedVehicles;

    public User(String username) {
        this.username = username;
        this.purchasedVehicles = new ArrayList<>();
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username, String email) {
        this.username = username;
    }


    public void addPurchasedVehicle(Vehicle vehicle) {
        purchasedVehicles.add(vehicle);
    }

    public void displayPurchasedVehicles() {
        if (purchasedVehicles.isEmpty()) {
            System.out.println("No purchased vehicles.");
        } else {
            System.out.println("Purchased Vehicles:");
            for (Vehicle vehicle : purchasedVehicles) {
                System.out.println(vehicle);
            }
        }
    }
}

