package fr.train_station;

import fr.train_station.entities.CustomersInfo;
import fr.train_station.entities.StationGateRecord;
import fr.train_station.entities.TripInfo;
import org.junit.Assert;
import org.junit.Test;
import fr.train_station.services.TrainTripService;

import java.util.Arrays;
import java.util.List;

public class MultipleCustomersTest {

    final TrainTripService TrainTripService = new TrainTripService();

    @Test
    public void should_returnExpectedCustomersInfo_when_MultipleTripFromStation_A_toStation_D() {

        StationGateRecord stationGateRecord1 = new StationGateRecord(1572242400, 1, "A");
        StationGateRecord stationGateRecord2 = new StationGateRecord(1572242400, 1, "D");
        StationGateRecord stationGateRecord3 = new StationGateRecord(1572282000, 1, "D");
        StationGateRecord stationGateRecord4 = new StationGateRecord(1572283800, 1, "A");

        StationGateRecord stationGateRecord5 = new StationGateRecord(1572242400, 2, "A");
        StationGateRecord stationGateRecord6 = new StationGateRecord(1572242400, 2, "D");
        StationGateRecord stationGateRecord7 = new StationGateRecord(1572282000, 2, "D");
        StationGateRecord stationGateRecord8 = new StationGateRecord(1572283800, 2, "A");

        List<StationGateRecord> stationGateRecords = Arrays.asList(stationGateRecord1, stationGateRecord2, stationGateRecord3, stationGateRecord4,
                stationGateRecord5, stationGateRecord6, stationGateRecord7, stationGateRecord8);
        List<CustomersInfo> customersInfo = TrainTripService.getMultipleCustomerInfo(stationGateRecords);

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
