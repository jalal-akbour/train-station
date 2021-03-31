package fr.train_station.entities;


import java.util.Objects;

public class TripInfo {


    private String stationStart;
    private String stationEnd;
    private Integer startedJourneyAt;
    private int costInCents;
    private int zoneFrom;
    private int zoneTo;

    public TripInfo() {
    }

    public TripInfo(String stationStart, String stationEnd, Integer startedJourneyAt, int costInCents, int zoneFrom, int zoneTo) {
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.startedJourneyAt = startedJourneyAt;
        this.costInCents = costInCents;
        this.zoneFrom = zoneFrom;
        this.zoneTo = zoneTo;
    }
    public String getStationStart() {
        return stationStart;
    }
    public void setStationStart(String stationStart) {
        this.stationStart = stationStart;
    }

    public String getStationEnd() {
        return stationEnd;
    }

    public void setStationEnd(String stationEnd) {
        this.stationEnd = stationEnd;
    }

    public Integer getStartedJourneyAt() {
        return startedJourneyAt;
    }

    public void setStartedJourneyAt(Integer startedJourneyAt) {
        this.startedJourneyAt = startedJourneyAt;
    }

    public int getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(int costInCents) {
        this.costInCents = costInCents;
    }

    public int getZoneFrom() {
        return zoneFrom;
    }

    public void setZoneFrom(int zoneFrom) {
        this.zoneFrom = zoneFrom;
    }

    public int getZoneTo() {
        return zoneTo;
    }

    public void setZoneTo(int zoneTo) {
        this.zoneTo = zoneTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripInfo tripInfo = (TripInfo) o;
        return costInCents == tripInfo.costInCents &&
                zoneFrom == tripInfo.zoneFrom &&
                zoneTo == tripInfo.zoneTo &&
                Objects.equals(stationStart, tripInfo.stationStart) &&
                Objects.equals(stationEnd, tripInfo.stationEnd) &&
                Objects.equals(startedJourneyAt, tripInfo.startedJourneyAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationStart, stationEnd, startedJourneyAt, costInCents, zoneFrom, zoneTo);
    }
}
