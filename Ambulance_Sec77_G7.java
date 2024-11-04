
/**
 * Afrah - 1090111
 * Aysha - 1088000
 * Mehejet - 1090225
 */

import java.util.ArrayList;

public final class Ambulance_Sec77_G7 implements Comparable<Ambulance_Sec77_G7> {
    private int ambulanceID;
    private int numberOfParamedics;
    private String currentLocation;
    private double calculatedDistanceFromTheCall;
    private boolean isAvailable = true;
    ArrayList<Record_Sec77_G7> recordsOfTheCallsAttended = new ArrayList<>();

    public Ambulance_Sec77_G7(int ambulanceID, String currentLocation, int numberOfParamedics) {
        this.ambulanceID = ambulanceID;
        this.currentLocation = currentLocation;
        this.numberOfParamedics = numberOfParamedics;
    }

    public Ambulance_Sec77_G7(int ambulanceID, int numberOfParamedics, String currentLocation,
            double calculatedDistanceFromTheCall) {
        setAmbulanceID(ambulanceID);
        setNumberOfParamedics(numberOfParamedics);
        setCurrentLocation(currentLocation);
        setCalculatedDistanceFromTheCall(calculatedDistanceFromTheCall);
    }

    public Ambulance_Sec77_G7() {

    }

    public int getNumberOfParamedics() {
        return numberOfParamedics;
    }

    public void setNumberOfParamedics(int numberOfParamedics) {
        this.numberOfParamedics = numberOfParamedics;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double getCalculatedDistanceFromTheCall() {
        return calculatedDistanceFromTheCall;
    }

    public void setCalculatedDistanceFromTheCall(double calculatedDistanceFromTheCall) {
        this.calculatedDistanceFromTheCall = calculatedDistanceFromTheCall;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setAsAvailable() {
        this.isAvailable = true;
    }

    public void setAsNotAvailable() {
        this.isAvailable = false;
    }

    public int getAmbulanceID() {
        return ambulanceID;
    }

    public void setAmbulanceID(int ambulanceID) {
        this.ambulanceID = ambulanceID;
    }

    public void addRecords(Record_Sec77_G7 record) {
        recordsOfTheCallsAttended.add(record);
    }

    @Override
    public int compareTo(Ambulance_Sec77_G7 other) {
        // TODO Auto-generated method stub
        return Double.compare(this.calculatedDistanceFromTheCall, other.calculatedDistanceFromTheCall);
    }

}
