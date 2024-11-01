import java.util.Arrays;

/**
 * Afrah - 1090111
 * Aysha - 1088000
 * Mehejet - 10
 */
public class EmergencyCall {
    private String callID; // automatically generated
    private int phoneNumber; // automatically found using math.random
    private String name;
    // MAth.random, for x ,y
    private double location;
    private String startTime;
    private String emergencyType; // medical, rescue, fire, accident,
    private String urgencyLevel;
    private String relatedCallID; // variabe
    private Ambulance[] ambulancesAssigned;
    private String status;
    private int callDuration;
    private String notes;

    // New Call / ongoing calls
    public EmergencyCall(Ambulance[] ambulancesAssigned, String callID, String emergencyType, double location,
            String name, String notes, int phoneNumber, String startTime, String status, String urgencyLevel) {
        this.ambulancesAssigned = ambulancesAssigned;
        this.callID = callID;
        this.emergencyType = emergencyType;
        this.location = location;
        this.name = name;
        this.notes = notes;
        this.phoneNumber = phoneNumber;
        this.startTime = startTime;
        this.status = status;
        this.urgencyLevel = urgencyLevel;
    }

    // If Related to another call
    public EmergencyCall(String callID, int phoneNumber, String name, double location, String startTime,
            String emergencyType, String urgencyLevel, String relatedCallID, String status, int callDuration,
            String notes) {
        this.callID = callID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.emergencyType = emergencyType;
        this.urgencyLevel = urgencyLevel;
        this.relatedCallID = relatedCallID;
        this.status = status;
        this.callDuration = callDuration;
        this.notes = notes;
    }

    // if call ended
    public EmergencyCall(String callID, int phoneNumber, String name, double location, String startTime,
            String emergencyType, String urgencyLevel, Ambulance[] ambulancesAssigned, String status, int callDuration,
            String notes) {
        this.callID = callID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.emergencyType = emergencyType;
        this.urgencyLevel = urgencyLevel;
        this.ambulancesAssigned = ambulancesAssigned;
        this.status = status;
        this.callDuration = callDuration;
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        return "EmergencyCall [callID=" + callID + ", phoneNumber=" + phoneNumber + ", name=" + name + ", location="
                + location + ", startTime=" + startTime + ", emergencyType=" + emergencyType + ", urgencyLevel="
                + urgencyLevel + ", ambulancesAssigned=" + Arrays.toString(ambulancesAssigned) + ", status=" + status
                + ", notes=" + notes + "]\n";
    }

    public String relatedCallToString() {
        return "EmergencyCall [callID=" + callID + ", phoneNumber=" + phoneNumber + ", name=" + name + ", location="
                + location + ", startTime=" + startTime + ", emergencyType=" + emergencyType + ", urgencyLevel="
                + urgencyLevel + ", relatedCallID=" + relatedCallID + ", ambulancesAssigned="
                + Arrays.toString(ambulancesAssigned) + ", status=" + status + ", callDuration=" + callDuration
                + ", notes=" + notes + "]\n";
    }

    public String resolvedCalltoString() {
        return "EmergencyCall [callID=" + callID + ", phoneNumber=" + phoneNumber + ", name=" + name + ", location="
                + location + ", startTime=" + startTime + ", emergencyType=" + emergencyType + ", urgencyLevel="
                + urgencyLevel + ", relatedCallID=" + relatedCallID + ", ambulancesAssigned="
                + Arrays.toString(ambulancesAssigned) + ", status=" + status + ", callDuration=" + callDuration
                + ", notes=" + notes + "]\n";
    }   

    public String getCallID() {
        return callID;
    }

    public void setCallID(String callID) {
        this.callID = callID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLocation() {
        return location;
    }

    public void setLocation(double location) {
        this.location = location;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getRelatedCall() {
        return relatedCallID;
    }

    public void setRelatedCalls(String relatedCallID) {
        this.relatedCallID = relatedCallID;
    }

    public Ambulance[] getAmbulancesAssigned() {
        return ambulancesAssigned;
    }

    public void setAmbulancesAssigned(Ambulance[] ambulancesAssigned) {
        this.ambulancesAssigned = ambulancesAssigned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
