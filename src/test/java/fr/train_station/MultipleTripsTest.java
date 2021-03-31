package fr.train_station;

import fr.train_station.entities.CustomersInfo;
import fr.train_station.entities.StationGateRecord;
import fr.train_station.entities.TripInfo;
import fr.train_station.exeptions.InvalidStationException;
import org.junit.Assert;
import org.junit.Test;
import fr.train_station.services.TrainTripService;

import java.util.Arrays;
import java.util.List;

public class MultipleTripsTest {


    final TrainTripService TrainTripService = new TrainTripService();

    @Test
    public void should_returnExpectedCustomersInfo_when_tripFromStation_A_toStation_D() throws InvalidStationException {

        StationGateRecord stationGateRecord1 = new StationGateRecord(1572242400, 1, "A");
        StationGateRecord stationGateRecord2 = new StationGateRecord(1572242400, 1, "D");
        StationGateRecord stationGateRecord3 = new StationGateRecord(1572282000, 1, "D");
        StationGateRecord stationGateRecord4 = new StationGateRecord(1572283800, 1, "A");

        CustomersInfo customersInfo = TrainTripService.getMultipleTripByCustomerInfo(1, Arrays.asList(stationGateRecord1, stationGateRecord2, stationGateRecord3, stationGateRecord4));

        TripInfo tripInfo1 = new TripInfo("A", "D", 1572242400, 240, 1, 2);
        TripInfo tripInfo2 = new TripInfo("D","A",1572282000,240,2,1);

        List<TripInfo> expected = Arrays.asList(tripInfo1,tripInfo2);
        Assert.assertEquals(expected, customersInfo.getTrips());
        Assert.assertEquals(1, customersInfo.getCustomerId());
        Assert.assertEquals(240+240, customersInfo.getTotalCostInCents());


    }

}
