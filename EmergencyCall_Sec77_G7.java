/**
 * Afrah - 1090111
 * Aysha - 1088000
 * Mehejet - 10
 */

import java.util.Arrays;

public class EmergencyCall_Sec77_G7 implements Comparable<EmergencyCall_Sec77_G7> {
    private int callID; // automatically generated
    private String phoneNumber; // automatically found using math.random
    private String name;
    // MAth.random, for x ,y
    private String location;
    private String startTime;
    private String emergencyType; // medical, rescue, fire, accident,
    private String urgencyLevel;
    private String relatedCallID; // variabe
    private Ambulance_Sec77_G7[] ambulancesAssigned;
    private String status;
    private int callDuration;
    private String notes;


    // If Related to another call
    public EmergencyCall_Sec77_G7(int callID, String phoneNumber, String name, String location, String startTime,
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
    public EmergencyCall_Sec77_G7(int callID, String phoneNumber, String name, String location, String startTime,
            String emergencyType, String urgencyLevel, Ambulance_Sec77_G7[] ambulancesAssigned, String status, int callDuration,
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
        return  callID + ", " + phoneNumber + ", " + name + ", "
                + location + ", " + startTime + ", " + emergencyType + ", "
                + urgencyLevel + ", " + Arrays.toString(ambulancesAssigned) + ", " + status
                + ", " + notes + "]\n";
    }

    public String relatedCallToString() {
        return  callID + ", " + phoneNumber + ", " + name + ", "
                + location + ", " + startTime + ", " + emergencyType + ", "
                + urgencyLevel + ", relatedCallID=" + relatedCallID + ", "
                + Arrays.toString(ambulancesAssigned) + ", " + status + ", " + callDuration
                + ", " + notes + "]\n";
    }

    public String resolvedCalltoString() {
        return  callID + ", " + phoneNumber + ", " + name + ", " + location + ", " + startTime + ", " + emergencyType + ", "
                + urgencyLevel + ", relatedCallID=" + relatedCallID + ", "
                + Arrays.toString(ambulancesAssigned) + ", " + status + ", " + callDuration
                + ", " + notes + "]\n";
    }   

    public int getCallID() {
        return callID;
    }

    public void setCallID(int callID) {
        this.callID = callID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
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

    public Ambulance_Sec77_G7[] getAmbulancesAssigned() {
        return ambulancesAssigned;
    }

    public void setAmbulancesAssigned(Ambulance_Sec77_G7[] ambulancesAssigned) {
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

    @Override
    public int compareTo(EmergencyCall_Sec77_G7 other) {
        return Integer.compare(this.callID, other.callID);
    }

}
