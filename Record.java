public final class Record {
    private String callID;
    private int estimatedTime;
    private int actualTime;

    public Record(String callID, int estimatedTime, int actualTime) {
        setCallID(callID);
        setEstimatedTime(estimatedTime);
        setActualTime(actualTime);
    }
    

    public String getCallID() {
        return callID;
    }

    public void setCallID(String callID) {
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
