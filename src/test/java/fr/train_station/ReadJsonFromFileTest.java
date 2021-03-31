package fr.train_station;

import fr.train_station.entities.CustomersInfo;
import fr.train_station.entities.StationGateRecord;
import fr.train_station.entities.TripInfo;
import org.junit.Assert;
import org.junit.Test;
import fr.train_station.services.TrainTripService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadJsonFromFileTest {

    final TrainTripService trainTripService = new TrainTripService();

    @Test
    public void should_returnExpectedCustomersInfo_when_ReadFrom_simpleInputFile1() throws IOException {

        String inputFile = "src/test/resources/simpleInputFile1.json";
        List<StationGateRecord> stationGateRecords = trainTripService.mapJsonToCustomersInfoList(inputFile);

        List<CustomersInfo> customersInfo = trainTripService.getMultipleCustomerInfo(stationGateRecords);

        TripInfo tripInfo1 = new TripInfo("A", "D", 1572242400, 240, 1, 2);
        TripInfo tripInfo2 = new TripInfo("D", "A", 1572282000, 240, 2, 1);

        List<TripInfo> expected1 = Arrays.asList(tripInfo1, tripInfo2);
        Assert.assertEquals(expected1, customersInfo.get(0).getTrips());
        Assert.assertEquals(1, customersInfo.get(0).getCustomerId());
        Assert.assertEquals(240+240, customersInfo.get(0).getTotalCostInCents());

    }

    @Test
    public void should_returnExpectedCustomersInfo_when_ReadFrom_simpleInputFile2() throws IOException {
        String inputFile = "src/test/resources/simpleInputFile2.json";
        List<StationGateRecord> stationGateRecords = trainTripService.mapJsonToCustomersInfoList(inputFile);

        List<CustomersInfo> customersInfo = trainTripService.getMultipleCustomerInfo(stationGateRecords);

        TripInfo tripInfo1 = new TripInfo("A", "D", 1572242400, 240, 1, 2);
        TripInfo tripInfo2 = new TripInfo("D", "A", 1572282000, 240, 2, 1);

        List<TripInfo> expected1 = Arrays.asList(tripInfo1, tripInfo2);
        List<TripInfo> expected2 = Arrays.asList(tripInfo1, tripInfo2);
        Assert.assertEquals(expected1, customersInfo.get(0).getTrips());
        Assert.assertEquals(expected2, customersInfo.get(1).getTrips());
        Assert.assertEquals(1, customersInfo.get(0).getCustomerId());
        Assert.assertEquals(2, customersInfo.get(1).getCustomerId());
        Assert.assertEquals(240+240, customersInfo.get(0).getTotalCostInCents());
        Assert.assertEquals(240+240, customersInfo.get(1).getTotalCostInCents());

    }

}
