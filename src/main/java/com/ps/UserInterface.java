package com.ps;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class UserInterface {
    private Dealership dealership;
    private User currentUser;
    private Scanner scanner;

    // Constructor: Initializes the user interface.
    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.currentUser = promptForUsername(); // Prompt for the username at the start
        init(); // Default user, implement login to change

    }

    // Prompt the user for their username
    private User promptForUsername() {
        System.out.print("Please enter your name: ");
        String username = scanner.nextLine().trim();
        return new User(username);
    }

    // Initializes the dealership data by loading it from a file.
    private void init() {
        DealershipFileManager instance = new DealershipFileManager();
        this.dealership = instance.getDealership("DB_Dealership.csv");  // Adjust the file name as needed.
    }

    // Display loop to handle user inputs.
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the main menu
            System.out.println("\n1. Display all vehicles");
            System.out.println("2. Find vehicles within a price range");
            System.out.println("3. Find vehicles by make and model");
            System.out.println("4. Find vehicles by year range");
            System.out.println("5. Find vehicles by color");
            System.out.println("6. Find vehicles by mileage range");
            System.out.println("7. Find vehicles by type");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("10. Checkout a vehicle");
            System.out.println("11. View My Purchased Vehicles");
            System.out.println("99. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processAllVehiclesRequest();
                    break;
                case 2:
                    processGetByPriceRequest(scanner);
                    break;
                case 3:
                    processGetByMakeModelRequest(scanner);
                    break;
                case 4:
                    processGetByYearRequest(scanner);
                    break;
                case 5:
                    processGetByColorRequest(scanner);
                    break;
                case 6:
                    processGetByMileageRequest(scanner);
                    break;
                case 7:
                    processGetByVehicleTypeRequest(scanner);
                    break;
                case 8:
                    processAddVehicleRequest(scanner);
                    break;
                case 9:
                    processRemoveVehicleRequest(scanner);
                    break;
                case 10:
                    processCheckoutRequest();
                    break;
                case 11:
                    processViewMyPurchasedVehicles();
                case 99:
                    System.out.println("Bye! Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 99);

        scanner.close();
    }

    // Method to display all vehicles.
    private void processAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);  // Display all vehicles using the helper method
    }

    // Find vehicles within a specific price range
    private void processGetByPriceRequest(Scanner scanner) {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                filteredVehicles.add(v);
            }
        }
        displayVehicles(filteredVehicles);  // Display filtered vehicles
    }

    // Find vehicles by make and model
    private void processGetByMakeModelRequest(Scanner scanner) {
        System.out.print("Enter the make of the vehicle: ");
        String make = scanner.next();

        System.out.print("Enter the model of the vehicle: ");
        String model = scanner.next();

        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                filteredVehicles.add(v);
            }
        }
        displayVehicles(filteredVehicles);  // Display filtered vehicles
    }

    // Find vehicles by year range
    private void processGetByYearRequest(Scanner scanner) {
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();

        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                filteredVehicles.add(v);
            }
        }
        displayVehicles(filteredVehicles);  // Display filtered vehicles
    }

    // Find vehicles by color
    private void processGetByColorRequest(Scanner scanner) {
        System.out.print("Enter color: ");
        String color = scanner.next();

        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getColor().equalsIgnoreCase(color)) {
                filteredVehicles.add(v);
            }
        }
        displayVehicles(filteredVehicles);  // Display filtered vehicles
    }

    // Find vehicles by mileage range
    private void processGetByMileageRequest(Scanner scanner) {
        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();

        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getOdometer() >= minMileage && v.getOdometer() <= maxMileage) {
                filteredVehicles.add(v);
            }
        }
        displayVehicles(filteredVehicles);  // Display filtered vehicles
    }

    // Find vehicles by type (e.g., Sedan, SUV)
    private void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.print("Enter vehicle type: ");
        String type = scanner.next();

        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVehicleType().equalsIgnoreCase(type)) {
                filteredVehicles.add(v);
            }
        }
        displayVehicles(filteredVehicles);  // Display filtered vehicles
    }

    // Add a new vehicle
    private void processAddVehicleRequest(Scanner scanner) {
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter make: ");
        String make = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();
        System.out.print("Enter type: ");
        String type = scanner.next();
        System.out.print("Enter color: ");
        String color = scanner.next();
        System.out.print("Enter odometer reading: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully.");
        // Save changes to the file
        new DealershipFileManager().saveDealership(dealership, "DB_Dealership.csv");
    }

    // Remove a vehicle by VIN
    private void processRemoveVehicleRequest
    (Scanner scanner) {
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vin = scanner.nextInt();

        Vehicle vehicleToRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                vehicleToRemove = v;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println("Vehicle removed successfully.");
            // Save changes to the file
            new DealershipFileManager().saveDealership(dealership, "DB_Dealership.csv");
        } else {
            System.out.println("Vehicle not found.");
        }
    }


    private void processCheckoutRequest() {
        System.out.println("Checkout Process");

        System.out.print("Enter the VIN of the vehicle you want to purchase or lease: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Vehicle vehicle = findVehicleByVin(vin);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.println("You selected: " + vehicle);
        System.out.println("The price of the vehicle is $" + vehicle.getPrice());

        System.out.print("Would you like to purchase with full cash, finance, or lease? (cash/finance/lease): ");
        String purchaseType = scanner.next();
        scanner.nextLine(); // Consume the newline

        if ("lease".equalsIgnoreCase(purchaseType)) {
            System.out.print("Enter the lease price: ");
            double leasePrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline

            System.out.print("Enter the end of lease purchase price: ");
            double endOfLeasePurchasePrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline

            LeaseContract leaseContract = new LeaseContract(
                    currentUser.getUsername(), currentUser.getCustomerEmail(),
                    vehicle, leasePrice, endOfLeasePurchasePrice
            );

            currentUser.addPurchasedVehicle(vehicle);
            dealership.removeVehicle(vehicle);
            System.out.println("Vehicle leased successfully. Thank you!");
        } else {
            double downPayment = 0;
            double interestRate = 0;
            double totalCost = vehicle.getPrice();

            if ("finance".equalsIgnoreCase(purchaseType)) {
                System.out.print("Enter the amount of down payment: ");
                downPayment = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline

                System.out.print("Enter your credit score: ");
                int creditScore = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                interestRate = determineInterestRate(creditScore);

                System.out.println("The interest rate according to your credit score (" + creditScore + ") is " + interestRate + "%");

                totalCost = vehicle.calculateTotalCost(downPayment, interestRate);
            }

            System.out.println("Total cost after applying down payment and interest: $" + totalCost);

            System.out.print("Proceed with checkout? (yes/no): ");
            String checkoutConfirm = scanner.next();
            scanner.nextLine(); // Consume the newline

            if ("yes".equalsIgnoreCase(checkoutConfirm)) {
                dealership.removeVehicle(vehicle);
                currentUser.addPurchasedVehicle(vehicle);
                System.out.println("Vehicle purchased successfully. Thank you!");
                new DealershipFileManager().saveDealership(dealership, "B_Dealership.csv");
            } else {
                System.out.println("Checkout canceled.");
            }
        }
    }

    private void processViewMyPurchasedVehicles() {
        currentUser.displayPurchasedVehicles();
    }

    // Helper method to find a vehicle by its VIN
    private Vehicle findVehicleByVin(int vin) {
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                return v;
            }
        }
        return null;
    }

    // Helper method to determine the interest rate based on credit score
    private double determineInterestRate(int creditScore) {
        if (creditScore >= 750) return 3.5;
        if (creditScore >= 700) return 4.0;
        if (creditScore >= 650) return 4.5;
        if (creditScore >= 600) return 5.0;
        if (creditScore >= 550) return 5.5;
        return 6.0;
    }

    // Helper method to display a list of vehicles
    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            System.out.println("\nListing All Vehicles:");
            System.out.println("| VIN    | Year | Make       | Model           | Type       | Color   | Odometer | Price      |");
            System.out.println("|--------|------|------------|-----------------|------------|---------|----------|------------|");
            for (Vehicle vehicle : vehicles) {
                System.out.println(String.format("| %-6d | %-4d | %-10s | %-15s | %-10s | %-7s | %8d | $%10.2f |",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
            }
        }
    }
}