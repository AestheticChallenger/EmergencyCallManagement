
/**
 * Afrah - 1090111
 * Aysha - 1088000
 * Mehejet - 10
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_Sec77_G7 {
    static Scanner input = new Scanner(System.in);
    static Ambulance_Sec77_G7[] ambulances = { new Ambulance_Sec77_G7(1, "Khalifa City", 2), new Ambulance_Sec77_G7(2, "Musaffah", 2),
            new Ambulance_Sec77_G7(3, "Al Reem Island", 3) };

    // creating tree for each risk levels
    static RedBlackTree_Sec77_G7 lowUrgencyLevelActiveCalls = new RedBlackTree_Sec77_G7();
    static RedBlackTree_Sec77_G7 mediumUrgencyLevelActiveCalls = new RedBlackTree_Sec77_G7();
    static RedBlackTree_Sec77_G7 highUrgencyLevelActiveCalls = new RedBlackTree_Sec77_G7();

    // callID will be in order so... we will use it like a counter
    static int callID = 1001;
    static int baniYasCityCounter = 0;
    static int khalidiyahCounter = 0;
    static int khalifaCityCounter = 0;
    static int mohammedBinZayedCityCounter = 0;
    static int musaffahCounter = 0;
    static int shahamaCounter = 0;
    static int yasIslandCounter = 0;
    static int alReemIslandCounter = 0;

    // static Ambulance
    public static void main(String[] args) {
        // creates all the folders and files
        createFoldersAndFiles();
        displayMainMenu();
        // I will do the option thing here

    }

    public static void displayMainMenu() {
        System.out.print("Welcome to emergency services" + "\n1. Insert New Call" + "\n2. Update Calls"
                + "\n3. Search Previous Calls" + "\n4. Show all Active Calls" + "\n5. Display the analytics" 
                + "\n0. Exit"
                + "\nPlease select the number next to the option you want to see: ");
        switch (input.nextInt()) {
            case 1:
                registerNewCall();
                break;

            case 2:
                updateCalls();
                break;

            case 3:
                // check teams to see team distribution
                searchPreviousCalls();
                break;

            case 4:
                showAllActiveCalls();
                break;

            case 5:
                displayAnalysis();
                break;

            case 0:
            System.exit(0);
                
        }

    }

    private static void displayAnalysis() {
        System.out.println("The most calls are from: ");
        List<Integer> locationCounters = new ArrayList<>();
        locationCounters.add(khalifaCityCounter);
        locationCounters.add(musaffahCounter);
        locationCounters.add(alReemIslandCounter);
        locationCounters.add(yasIslandCounter);
        locationCounters.add(shahamaCounter);
        locationCounters.add(khalidiyahCounter);
        locationCounters.add(mohammedBinZayedCityCounter);
        locationCounters.add(baniYasCityCounter);

        Object[][] locations = { { "Khalifa City", khalifaCityCounter }, { "Musaffah", musaffahCounter },
                { "Al Reem Island", alReemIslandCounter }, { "Yas Island", yasIslandCounter },
                { "Shahama", shahamaCounter }, { "Khalidiyah", khalidiyahCounter },
                { "Mohammed Bin Zayed City", mohammedBinZayedCityCounter }, { "Bani Yas City", baniYasCityCounter } };

               int maximumCalls = Collections.max(locationCounters);
                for (Object[] location : locations) {
                    if (maximumCalls == (int) (location[1])) {
                        System.out.println(location[0]);
                        break;
                    }
                }
        
        Ambulance_Sec77_G7 maximumWorkedAmbulance = ambulances[0];
        for (Ambulance_Sec77_G7 ambulance : ambulances) {
            if (maximumWorkedAmbulance.recordsOfTheCallsAttended.size() < ambulance.recordsOfTheCallsAttended.size())
            maximumWorkedAmbulance = ambulance;
        }

        System.out.println("The ambulance which responded to most of the calls: " + maximumWorkedAmbulance.getAmbulanceID());

        System.out.println("Returning to main menu: ");
        displayMainMenu();
    }

    // change the void type to anything

    public static void registerNewCall() {
        int callerID = callID;

        System.out.print("Enter Name: ");
        String name = input.next() + input.nextLine();

        // print this line
        String phoneNumber = getPhoneNumber();

        // make a numbered list to select from the option here
        String emergencyType = getEmergencyType();

        System.out.print("Enter Urgency Level: ");
        String urgencyLevel = input.next() + input.nextLine();

        double location = (Math.random() * 40); // 0 -> 39.. so 7 last value

        String locationCategory = "";
        switch ((int) (location / 5)) {
            case 0:
                locationCategory = "Khalifa City";
                khalifaCityCounter++;
                break;
            case 1:
                locationCategory = "Musaffah";
                musaffahCounter++;
                break;
            case 2:
                locationCategory = "Al Reem Island";
                alReemIslandCounter++;
                break;
            case 3:
                locationCategory = "Yas Island";
                yasIslandCounter++;
                break;
            case 4:
                locationCategory = "Shahama";
                shahamaCounter++;
                break;
            case 5:
                locationCategory = "Khalidiyah";
                khalidiyahCounter++;
                break;
            case 6:
                locationCategory = "Mohammed Bin Zayed City";
                mohammedBinZayedCityCounter++;
                break;
            case 7:
                locationCategory = "Bani Yas City";
                baniYasCityCounter++;
                break;
        }

        System.out.println("Location: " + locationCategory);

        System.out.print("Enter Start Time: ");
        String startTime = getStartTime();
        System.out.println(startTime);

        System.out.print("Enter Notes: ");
        String notes = input.next() + input.nextLine();

        Ambulance_Sec77_G7[] ambulanceAssigned = getAmbulance(location);

        // calculate the distance and add the ambulance objects in another bst and add
        // it to the ambulanceAssigned

        int relatedCallID = -1;
        System.out.print("Is this call related to another call? (yes/no): ");
        String isRelated = input.next().toUpperCase().trim();
        if (isRelated.charAt(0) == 'Y') {
            System.out.print("Enter related call ID: ");
            relatedCallID = input.nextInt();
        }

        System.out.print("Enter status (Active/Resolved): ");
        String status = input.next().trim().toUpperCase();

        System.out.print("Enter the call duration: ");
        int callDuration = input.nextInt();

        EmergencyCall_Sec77_G7 newCall;
        if (relatedCallID != -1)
            newCall = new EmergencyCall_Sec77_G7(callerID, phoneNumber, name, locationCategory, startTime, emergencyType,
                    urgencyLevel, ambulanceAssigned, status, callDuration, notes);

        else {
            newCall = new EmergencyCall_Sec77_G7(callerID, phoneNumber, name, locationCategory, startTime, emergencyType,
                    urgencyLevel, isRelated, status, callDuration, notes);
        }

        switch (urgencyLevel.charAt(0)) {
            case 'l':
                lowUrgencyLevelActiveCalls.insert(newCall);
                lowUrgencyLevelActiveCalls.print();
                break;

            case 'm':
                mediumUrgencyLevelActiveCalls.insert(newCall);
                mediumUrgencyLevelActiveCalls.print();
                break;

            case 'h':
                highUrgencyLevelActiveCalls.insert(newCall);
                highUrgencyLevelActiveCalls.print();
                break;
        }

        callID++; // increases the callID, for the next call
        System.out.println("Emergency call registered successfully!");
        System.out.print("Do you wish to add another call? [yes / no]");
        char userInput = input.next().trim().toUpperCase().charAt(0);
        switch (userInput) {
            case 'Y':
                registerNewCall();
                break;

            default:
                displayMainMenu();
                break;
        }

    }

    public static void searchPreviousCalls() {
        char loop = 'Y';
        do {
            System.out.print("Enter the urgency level (Low, Medium, High): ");
            String urgencyLevel = input.next().trim().toLowerCase();

            System.out.print("Enter callID to search: ");
            int callID = input.nextInt();

            switch (urgencyLevel.charAt(0)) {
                case 'l':
                    // Handle low urgency calls
                    searchCallById(lowUrgencyLevelActiveCalls.getRoot(), callID);
                    break;

                case 'm':
                    // Handle medium urgency calls
                    searchCallById(mediumUrgencyLevelActiveCalls.getRoot(), callID);
                    break;

                case 'h':
                    // Handle high urgency calls
                    searchCallById(highUrgencyLevelActiveCalls.getRoot(), callID);
                    break;
            }

            System.out.println("Do you wish to go continue searching? [yes / no]");
            loop = input.next().trim().toUpperCase().charAt(0);
        } while (loop == 'Y');

        displayMainMenu();

    }

    // Search for the EmergencyCall by callID
    public static void searchCallById(TreeNode_Sec77_G7<EmergencyCall_Sec77_G7> node, int callID) {
        while (node != null) {
            if (callID < node.element.getCallID()) {
                node = node.left; // Move to the left subtree
            } else if (callID > node.element.getCallID()) {
                node = node.right; // Move to the right subtree
            } else {
                System.out.print("Call found " + node.element);
                break; // Match found
            }
        }
        System.out.println(" Call not found ");
    }

    public static String getPhoneNumber() {
        int countryCode = 0;
        int phoneNumber = (int) (Math.random() * 10000000) - 1000000;

        // 70% or 80% chance the phone number is UAE number
        int chance = (int) (Math.random() * 10) / 7;

        // gets the country code
        switch (chance) {
            case 0:
                countryCode = 971;
                break;
            default:
                countryCode = (int) (Math.random() * 999);
        }

        return "+" + countryCode + " " + phoneNumber;
    }

    public static void createFoldersAndFiles() {
        String[] locationNames = { "Khalifa City", "Musaffah", "Al Reem Island", "Yas Island", "Shahama", "Khalidiyah",
                "Mohammed Bin Zayed City", "Bani Yas City" };

        for (String folderName : locationNames) {
            File subFolder = new File("Locations/" + folderName);
            if (!subFolder.exists()) {
                subFolder.mkdirs();
                File resolvedCalls = new File(subFolder, "Resolved_Calls.csv");
                File ongoingCalls = new File(subFolder, "Ongoing_Calls.csv");
                try (FileWriter writer = new FileWriter(resolvedCalls)) {
                    writer.write("");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                try (FileWriter writer = new FileWriter(ongoingCalls)) {
                    writer.write("");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void showAllActiveCalls() {
        System.out.println("Active Calls:");

        // Display active calls from the Low urgency level
        System.out.println("Low Urgency Calls:");
        printActiveCalls(lowUrgencyLevelActiveCalls.getRoot());

        // Display active calls from the Medium urgency level
        System.out.println("\nMedium Urgency Calls:");
        printActiveCalls(mediumUrgencyLevelActiveCalls.getRoot());

        // Display active calls from the High urgency level
        System.out.println("\nHigh Urgency Calls:");
        printActiveCalls(highUrgencyLevelActiveCalls.getRoot());

        System.out.println("\nReturning to Main Menu...");
        displayMainMenu();
    }

    public static void printActiveCalls(TreeNode_Sec77_G7<EmergencyCall_Sec77_G7> node) {

        if (node == null) {
            System.out.println("No active calls at the moment.");
            return;
        }

        String[] columnNames = { "Phone Number", "Name", "Location", "Start Time", "Emergency Type", "Urgency Level",
                "Status", "Related Call ID" };

        for (int i = 0; i < columnNames.length; i++) {
            System.out.printf("%-15s", columnNames[i]);
        }

        System.out.println();
        System.out.println("---------------------------------------------------------------");

        printActiveCalls(node.left);
        System.out.println(node.element);
        printActiveCalls(node.right);

    }

    public static void updateCalls() {

        char condition = 'Y';
        do {
            System.out.print("\nEnter the Call ID to update: ");
            int callID = input.nextInt();
            input.nextLine(); // consume newline

            System.out.print("Enter the urgency level (Low, Medium, High): ");
            String urgencyLevel = input.nextLine().trim().toLowerCase();

            RedBlackTree_Sec77_G7<EmergencyCall_Sec77_G7> activeCallsTree;

            switch (urgencyLevel) {
                case "low":
                    activeCallsTree = lowUrgencyLevelActiveCalls;
                    break;
                case "medium":
                    activeCallsTree = mediumUrgencyLevelActiveCalls;
                    break;
                case "high":
                    activeCallsTree = highUrgencyLevelActiveCalls;
                    break;
                default:
                    System.out.println("Invalid urgency level.");
                    return;
            }

            EmergencyCall_Sec77_G7 callToUpdate = findCallById(activeCallsTree, callID);
            if (callToUpdate == null) {
                System.out.println("No active call found with Call ID: " + callID);
                return;
            }

            System.out.print("Has this call been resolved? (yes/no): ");
            String resolvedInput = input.next().trim().toLowerCase();

            if (resolvedInput.charAt(0) == 'y') {
                callToUpdate.setStatus("RESOLVED");
                activeCallsTree.print();

                String locationfoldername = "Locations/" + callToUpdate.getLocation() + "/" + "Resolved_Calls.csv";

                // System.out.println(locationfoldername);
                Ambulance_Sec77_G7 assignedAmbulance[] = callToUpdate.getAmbulancesAssigned();
                for (Ambulance_Sec77_G7 ambulance : assignedAmbulance) {
                    ambulance.recordsOfTheCallsAttended.add(new Record_Sec77_G7(callID, (int) (Math.random() * 20), (int) (Math.random() * 20)));
                    ambulance.setAsAvailable();
                }

                // Remove the resolved call from the Red-Black Tree
                if (callToUpdate.getStatus().equals("RESOLVED")) {
                    writeCallToFile(locationfoldername, callToUpdate);
                    activeCallsTree.deleteByTheElement(callToUpdate);
                    System.out.println(
                            "Call " + callToUpdate.getCallID() + " marked as resolved and removed from active calls.");
                    // Optionally, log resolved calls to a file or another data structure.
                } else {
                    System.out.println("Error: Call could not be removed from the tree.");
                }
            } else {
                System.out.println("No changes made to call " + callID + ".");
            }
            System.out.println("\nDo you wish to continue updating calls? [yes / no]");
            condition = input.next().trim().toUpperCase().charAt(0);
        } while (condition == 'Y');
    }

    private static void writeCallToFile(String foldername, EmergencyCall_Sec77_G7 call) {
        try {

            String folderName;

            // Match the call location to a specific file name based on location
            switch (call.getLocation().toLowerCase()) {
                case "khalidiyah":
                    foldername = "Locations/Khalidiyah";
                    break;
                case "musaffah":
                    foldername = "Locations/Musaffah";
                    break;
                case "shahama":
                    foldername = "Locations/Shahama";
                    break;
                case "al reem island":
                    foldername = "Locations/Al Reem Island";
                    break;
                case "bani yas city":
                    foldername = "Locations/Bani Yas City";
                    break;
                case "khalifa city":
                    foldername = "Locations/Khalifa City";
                    break;
                case "mohammed bin zayed city":
                    foldername = "Locations/Mohammed Bin Zayed City";
                    break;
                case "yas island":
                    foldername = "Locations/Yas Island";
                    break;
            }
            // Create a FileWriter in append mode
            FileWriter writer = new FileWriter(foldername + "/Resolved_Calls.csv");

            // Write the call's string representation directly to the file
            writer.write(call.toString());
            writer.write(System.lineSeparator()); // Add a new line after the call's details

            // Close the writer to release resources
            writer.close();

            System.out.println("Resolved call written to file: " + foldername);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + foldername);
            e.printStackTrace();
        }
    }

    private static EmergencyCall_Sec77_G7 findCallById(RedBlackTree_Sec77_G7<EmergencyCall_Sec77_G7> tree, int callID) {
        TreeNode_Sec77_G7<EmergencyCall_Sec77_G7> node = tree.getRoot();
        while (node != tree.NIL) {
            if (callID < node.element.getCallID()) {
                node = node.left;
            } else if (callID > node.element.getCallID()) {
                node = node.right;
            } else {
                return node.element;
            }
        }
        return null; // Call not found
    }

    private static Ambulance_Sec77_G7[] getAmbulance(double callLocation) {
        RedBlackTree_Sec77_G7 DistanceBST = new RedBlackTree_Sec77_G7();
        int counter = 0; // for checking if there is no available ambulances
        for (Ambulance_Sec77_G7 ambulance : ambulances) {
            int location = 0;
            if (!ambulance.isIsAvailable()) {
                counter++;
                if (counter >= ambulances.length) {
                    System.out.println("There is no available ambulances. Please wait.");
                    return null;
                }
            }

            // if there are available ambulances
            else {
                switch (ambulance.getCurrentLocation()) {
                    case "Khalifa City":
                        location = 10 + (int) (Math.random() * 5); // 10 to 14
                        break;
                    case "Musaffah":
                        location = 15 + (int) (Math.random() * 5); // 15 to 19
                        break;
                    case "Al Reem Island":
                        location = 20 + (int) (Math.random() * 5); // 20 to 24
                        break;
                    case "Yas Island":
                        location = 25 + (int) (Math.random() * 5); // 25 to 29
                        break;
                    case "Shahama":
                        location = 30 + (int) (Math.random() * 5); // 30 to 34
                        break;
                    case "Khalidiyah":
                        location = 35 + (int) (Math.random() * 5); // 35 to 39
                        break;
                    case "Mohammed Bin Zayed City":
                        location = 40 + (int) (Math.random() * 5); // 40 to 44
                        break;
                    case "Bani Yas City":
                        location = 45 + (int) (Math.random() * 5); // 45 to 49
                        break;
                    default:
                        location = -1; // Invalid location category
                        System.out.println("Invalid location category");

                }

                ambulance.setCalculatedDistanceFromTheCall(CalculatedDistanceFromTheCall(location, callLocation));

                DistanceBST.insert(ambulance);

            }

        } 

        System.out.println("\nAvailable Ambulances (in tree) : ");
        DistanceBST.print();

        System.out.print("\nHow many ambulances needed? ");
        int userInput = input.nextInt();
        Ambulance_Sec77_G7[] availabAmbulances = new Ambulance_Sec77_G7[userInput];

        if (userInput <= 0) {

            return null;
        }

        else {

            for (int i = 0; i < availabAmbulances.length; i++) {
                // gets the nearest ambulance, removes it from bst to get the second nearest...
                // if needed
                availabAmbulances[i] = DistanceBST.findNearestAmbulance(DistanceBST.root);
                availabAmbulances[i].setAsNotAvailable(); // because they are assigned to a call
                DistanceBST.deleteByTheElement(availabAmbulances[i]);
            }
        }

        return availabAmbulances;

    }

    public static double CalculatedDistanceFromTheCall(double location1, double location2) {
        return Math.abs(location2 - location1);
    }

    private static String getStartTime() {
        // hour : minutes : seconds
        return String.format("%02d:%02d:%02d", (Math.round(Math.random() * 23)), (Math.round(Math.random() * 59)),
                (Math.round(Math.random() * 59)));
    }

    private static String getEmergencyType() {
    String emergencyType = "";
        while (emergencyType.equals("")) {
            System.out.println("\nSelect Emergency Type: ");
            System.out.println("\n1. Medical");
            System.out.println("\n2. Rescue");
            System.out.println("\n3. Fire");
            System.out.println("\n4. Accident");
            System.out.println("Enter your choice (1-4): ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    emergencyType = "Medical";
                    break;
                case 2:
                    emergencyType = "Rescue";
                    break;
                case 3:
                    emergencyType = "Fire";
                    break;
                case 4:
                    emergencyType = "Accident";
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }
            break;
        }
        System.out.println("You selected: " + emergencyType);

        return emergencyType;
    }

}