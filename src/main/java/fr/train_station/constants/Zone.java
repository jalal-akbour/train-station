package fr.train_station.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [Stations and zones]
 * Zone 1 stations:
 * A, B
 * <p>
 * Zone 2 stations:
 * C, D, E
 * <p>
 * Zone 3 stations:
 * C, E, F
 * <p>
 * Zone 4 stations:
 * F, G, H, I
 */

public enum Zone {
    zone1(1, Arrays.asList("A", "B")),
    zone2(2, Arrays.asList("C", "D", "E")),
    zone3(3, Arrays.asList("C", "E", "F")),
    zone4(4, Arrays.asList("F", "G", "H", "I"));

    private final List<String> stations;
    public final int zoneId;

    Zone(int zoneId, List<String> stations) {
        this.zoneId = zoneId;
        this.stations = stations;
    }

    public List<String> getStations() {
        return new ArrayList<>(stations);
    }

    public boolean containStation(String station){
        return this.getStations().contains(station);
    }
}
