package fr.train_station.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import fr.train_station.constants.Pricing;
import fr.train_station.constants.Zone;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.train_station.entities.CustomersInfo;
import fr.train_station.entities.StationGateRecord;
import fr.train_station.entities.TripInfo;
import fr.train_station.exeptions.InvalidStationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TrainTripService {

    public Pricing getPricingOfTrip(String stationStart, String stationEnd) throws InvalidStationException {
        List<Zone> zonesOfStationStart = getZonesOfStation(stationStart);
        List<Zone> zonesOfStationEnd = getZonesOfStation(stationEnd);

        return getPriceOfTrip(zonesOfStationStart, zonesOfStationEnd);
    }

    private List<Zone> getZonesOfStation(String station) throws InvalidStationException {
        List<Zone> zones = Arrays.stream(Zone.values()).filter(zone -> zone.containStation(station))
                .collect(Collectors.toList());
        if (zones.isEmpty()) {
            throw new InvalidStationException("Invalid station value : " + station);
        }

        return zones;
    }

    private Pricing getPriceOfTrip(List<Zone> zonesStart, List<Zone> zonesEnd) {
        return Arrays.stream(Pricing.values())
                .filter(x -> zonesStart.contains(x.zoneStart) && zonesEnd.contains(x.zoneEnd))
                .min(Comparator.comparingInt(s -> s.tripPrice)).get();
    }

    public TripInfo populateTripInfo(StationGateRecord stationGateRecord1, StationGateRecord stationGateRecord2) throws InvalidStationException {
        TripInfo tripInfo = new TripInfo();
        Pricing pricing = getPricingOfTrip(stationGateRecord1.getStation(), stationGateRecord2.getStation());

        tripInfo.setStationStart(stationGateRecord1.getStation());
        tripInfo.setStationEnd(stationGateRecord2.getStation());
        tripInfo.setStartedJourneyAt(stationGateRecord1.getUnixTimestamp());
        tripInfo.setCostInCents(pricing.tripPrice);
        tripInfo.setZoneFrom(pricing.zoneStart.zoneId);
        tripInfo.setZoneTo(pricing.zoneEnd.zoneId);
        return tripInfo;
    }

    public CustomersInfo getMultipleTripByCustomerInfo(int customerId, List<StationGateRecord> asList) throws InvalidStationException {
        List<TripInfo> tripInfos = new ArrayList<>();
        int totalCostInCents = 0;
        //int customerId = asList.get(0).getCustomerId();

        for (int i = 0; i < asList.size(); i = i + 2) {
            TripInfo tripInfo = populateTripInfo(asList.get(i), asList.get(i + 1));
            totalCostInCents += tripInfo.getCostInCents();
            tripInfos.add(tripInfo);
        }

        return new CustomersInfo(customerId, totalCostInCents, tripInfos);
    }

    public List<CustomersInfo> getMultipleCustomerInfo(List<StationGateRecord> stationGateRecords) {
        List<CustomersInfo> customersInfos = new ArrayList<>();
        stationGateRecords.stream()
                .collect(groupingBy(StationGateRecord::getCustomerId))
                .forEach((k, v) -> {
                    try {
                        customersInfos.add(getMultipleTripByCustomerInfo(k, v));
                    } catch (InvalidStationException e) {
                        e.printStackTrace();
                    }
                });

        return customersInfos;
    }

    public void customerSummariesFileGeneration(String outputFilePath, List<CustomersInfo> customersInfos) throws JsonProcessingException {
        String arrayToJson = mapCustomersInfoToJsonAsString(customersInfos);
        writeInFile(outputFilePath, arrayToJson);
    }

    public List<StationGateRecord> mapJsonToCustomersInfoList(String inputFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File inputFile = new File(inputFilePath);
        JsonNode travelNodes = objectMapper.readValue(inputFile, JsonNode.class).get("taps");
         return objectMapper.readValue(travelNodes.toString(), new TypeReference<List<StationGateRecord>>(){});
    }

    private void writeInFile(String path, String arrayToJson) {
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(arrayToJson);

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String mapCustomersInfoToJsonAsString(List<CustomersInfo> customersInfos) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writer()
                .withRootName("customerSummaries")
                .withDefaultPrettyPrinter()
                .writeValueAsString(customersInfos);
    }
}
