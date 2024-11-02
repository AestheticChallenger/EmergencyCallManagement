import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    // creating tree for each risk levels
    static RedBlackTree LowUrgencyLevelActiveCalls = new RedBlackTree(null);
    static RedBlackTree MediumUrgencyLevelActiveCalls = new RedBlackTree(null);
    static RedBlackTree HighUrgencyLevelActiveCalls = new RedBlackTree(null);

    // static Ambulance 
    public static void main(String[] args) {
        // creates all the folders and files
        createFoldersAndFiles();
        displayMainMenu();
        // I will do the option thing here

    }

    public static void displayMainMenu() {
        System.out.println("\n1. Insert New Call"
                + "\n2. View Previous Calls");
        switch (input.nextInt()) {
            case 1:
                registerNewCall();
                break;

            case 2:
                // check teams to see team distribution
                SearchPreviousCalls();
                break;

            case 3:
                showAllActiveCalls();
                break;

            case 4:
                displayAnalysis();
                break;

            case 5:
                updateActiveCallStatus();
                break;

            default:
                throw new AssertionError();
        }

    }

    private static void displayAnalysis() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayAnalysis'");
    }

    // change the void type to anything

    public static void registerNewCall() {
        int callID = (int) ((Math.random() * 10000) - 1000);

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        String phoneNumber = getPhoneNumber();

        // Math.random() *

        Random random = new Random();
        double location = 10 + (50 - 10) * random.nextDouble();// hssjdf

        String locationCategory;
        if (location >= 10 && location < 15) {
            locationCategory = "Khalifa City";
        } else if (location >= 15 && location < 20) {
            locationCategory = "Musaffah";
        } else if (location >= 20 && location < 25) {
            locationCategory = "Al Reem Island";
        } else if (location >= 25 && location < 30) {
            locationCategory = "Yas Island";
        } else if (location >= 30 && location < 35) {
            locationCategory = "Shahama";
        } else if (location >= 35 && location < 40) {
            locationCategory = "Khalidiyah";
        } else if (location >= 40 && location < 45) {
            locationCategory = "Mohammed Bin Zayed City";
        } else if (location >= 45 && location < 50) {
            locationCategory = "Bani Yas City";
        } else {
            locationCategory = "Unknown Location";
        }

        String locationName = "";
        switch (locationName) {

            case "Khalifa City":
                locationName = "Khalifa City";
                break;

            case "Musaffah":
                locationName = "Musaffah";
                break;

            case "Al Reem Island":
                locationName = "Al Reem Island";
                break;

            case "Yas Island":
                locationName = "Yas Island";
                break;

            case "Shahama":
                locationName = "Shahama";
                break;

            case "Khalidiyah":
                locationName = "Khalidiyah";
                break;

            case "Mohammed Bin Zayed City":
                locationName = "Mohammed Bin Zayed City";
                break;

            case "Bani Yas City":
                locationName = "Bani Yas City";
                break;

            default:
                locationName = "Unknown Location";
                break;
        }

        System.out.print("Enter Emergency type(Medical/Rescue/Fire/Accident): ");
        String emergencyType = input.nextLine();

        System.out.print("Enter Urgency Level: ");
        String urgencyLevel = input.nextLine();

        System.out.print("Enter Location: " + locationCategory + "(" + String.format(locationName, "%.2f") + ")");

        System.out.print("Enter status (Active/Resolved): ");
        String status = input.nextLine();

        System.out.print("Enter Start Time: ");
        String startTime = getStartTime();

        System.out.print("Enter Notes: ");
        String notes = input.nextLine();
        Ambulance[] ambulanceAssigned = {};

        String relatedCallID = null;
        System.out.print("Is this call related to another call? (yes/no): ");
        String isRelated = input.nextLine();
        if (isRelated.equalsIgnoreCase("yes")) {
            System.out.print("Enter related call ID: ");
            relatedCallID = input.nextLine();
        }

        EmergencyCall newCall1 = new EmergencyCall(ambulanceAssigned, callID, emergencyType, locationName, name, notes,
                phoneNumber, startTime, status, urgencyLevel);

        switch (urgencyLevel) {
            case "low":
                LowUrgencyLevelActiveCalls.insert(newCall1);
                LowUrgencyLevelActiveCalls.print();
                break;

            case "medium":
                MediumUrgencyLevelActiveCalls.insert(newCall1);
                MediumUrgencyLevelActiveCalls.print();
                break;

            case "high":
                HighUrgencyLevelActiveCalls.insert(newCall1);
                HighUrgencyLevelActiveCalls.print();
                break;
        }
        System.out.print("Emergency call registered successfully!");

    }

    public static void SearchPreviousCalls() {
        // throw new UnsupportedOperationException("Not supported yet.");
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
        File mainFolder = new File("Locations");
        String[] locationNames = {
                "Khalifa City",
                "Musaffah",
                "Al Reem Island",
                "Yas Island",
                "Shahama",
                "Khalidiyah",
                "Mohammed Bin Zayed City",
                "Bani Yas City"
        };
        // if (!mainFolder.mkdirs()) {

        // }

        for (String folderName : locationNames) {
            File subFolder = new File(mainFolder + "/" + folderName);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void updateActiveCallStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static String getStartTime() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
