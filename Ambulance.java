
public class Ambulance {
    private int numberOfParamedics;
    private String currentLocation;
    private double calculatedDistanceFromTheCall;
    private boolean isAvailable = true;

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

    


    

    
}
