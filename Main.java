import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // creates all the folders and files
        createFoldersAndFiles();

        // gets the phone number automatically
        System.out.println(getPhoneNumber()); // checking if phone number works
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
        // throw new UnsupportedOperationException("Not supported yet.");
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

        for (String folderName : locationNames) {
            File subFolder = new File(mainFolder + folderName);
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

    public  static void showAllActiveCalls() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void updateActiveCallStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
