import java.io.File;
import java.util.Scanner;



public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        File folder = new File("Locations");
        File subFolder1 = new File("Locations/Khalifa City");
        // File subFolder2 = new File("Locations/");
        // File subFolder3 = new File("Locations/");
        // File subFolder4 = new File("Locations/");
        // File subFolder5 = new File("Locations/");
        // File subFolder6 = new File("Locations/");
        // File subFolder7 = new File("Locations/");
        // File subFolder8 = new File("Locations/");
        // File subFolder9 = new File("Locations/");
        // File subFolder10 = new File("Locations/");

        // ResolvedCalls
        // OngoingCalls

        if (folder.mkdirs() && subFolder1.mkdirs()
        //  && subFolder2.mkdirs()
         ) {
            System.out.println("Folder created successfully");
        }

        else {
            System.out.println("File exists.");
        }

        System.out.println(getPhoneNumber()); //checking if phone number works
    }

    public static void displayMainMenu() {
        System.out.println("\n1. Insert New Call"
        + "\n2. View Previous Calls");
        switch (input.nextInt()) {
            case 1:
                registerNewCall();
                break;

            case 2:
                SearchPreviousCalls();
                break;
            default:
                throw new AssertionError();
        }

    }

    public static void registerNewCall() {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void SearchPreviousCalls() {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public static int getPhoneNumber() {
        int countryCode = 0;
        int phoneNumber = (int) (Math.random() * 10000000);

        // 70% or 80% chance the phone number is UAE number
        int chance = (int) (Math.random() * 10) / 7;
        
        //gets the country code
        switch (chance) {
            case 0:
                countryCode = 971;
                break;
            default:
                countryCode = (int) (Math.random() * 999);
        }
        
        return countryCode;
    }
}
