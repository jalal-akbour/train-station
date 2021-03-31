package fr.train_station.entities;

public class StationGateRecord {

    private Integer unixTimestamp;
    private Integer customerId;
    private String station;

    public StationGateRecord() {
    }

    public StationGateRecord(Integer unixTimestamp, Integer customerId, String station) {
        this.unixTimestamp = unixTimestamp;
        this.customerId = customerId;
        this.station = station;
    }

    public Integer getUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(Integer unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "InputFileDto{" +
                "unixTimestamp=" + unixTimestamp +
                ", time=" + new java.util.Date((long)unixTimestamp*1000) +
                ", customerId=" + customerId +
                ", station='" + station + '\'' +
        '}';
    }
}
