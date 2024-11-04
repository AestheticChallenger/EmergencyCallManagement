/**
 * Afrah - 1090111
 * Aysha - 1088000
 * Mehejet - 10
 */

public final class Record_Sec77_G7 {
    private int callID;
    private int estimatedTime;
    private int actualTime;

    public Record_Sec77_G7(int callID, int estimatedTime, int actualTime) {
        setCallID(callID);
        setEstimatedTime(estimatedTime);
        setActualTime(actualTime);
    }
    

    public int getCallID() {
        return callID;
    }

    public void setCallID(int callID) {
        this.callID = callID;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getActualTime() {
        return actualTime;
    }

    public void setActualTime(int actualTime) {
        this.actualTime = actualTime;
    }


}
