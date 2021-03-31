package fr.train_station.entities;

import java.util.List;

public class CustomersInfo {

    private int customerId;
    private int totalCostInCents;
    List<TripInfo> trips;

    public CustomersInfo(int customerId, int totalCostInCents, List<TripInfo> trips) {
        this.customerId = customerId;
        this.totalCostInCents = totalCostInCents;
        this.trips = trips;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTotalCostInCents() {
        return totalCostInCents;
    }

    public void setTotalCostInCents(int totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }

    public List<TripInfo> getTrips() {
        return trips;
    }

    public void setTrips(List<TripInfo> trips) {
        this.trips = trips;
    }
}
