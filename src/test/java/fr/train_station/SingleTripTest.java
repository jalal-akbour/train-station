package fr.train_station;

import fr.train_station.entities.StationGateRecord;
import fr.train_station.entities.TripInfo;
import fr.train_station.exeptions.InvalidStationException;
import org.junit.Assert;
import org.junit.Test;
import fr.train_station.services.TrainTripService;

public class SingleTripTest {

    final TrainTripService TrainTripService = new TrainTripService();

    @Test
    public void should_returnExpectedTripInfo_when_tripFromStation_A_toStation_D() throws InvalidStationException {

        StationGateRecord stationGateRecord1 = new StationGateRecord(1572242400,1,"A");
        StationGateRecord stationGateRecord2 = new StationGateRecord(1572242400,1,"D");
        TripInfo tripInfo = TrainTripService.populateTripInfo(stationGateRecord1, stationGateRecord2);

        TripInfo expected = new TripInfo("A","D",1572242400,240,1,2);

        Assert.assertEquals(expected, tripInfo);

    }

    @Test
    public void should_returnExpectedTripInfo_when_tripFromStation_D_toStation_A() throws InvalidStationException {

        StationGateRecord stationGateRecord1 = new StationGateRecord(1572242400,1,"A");
        StationGateRecord stationGateRecord2 = new StationGateRecord(1572242400,1,"D");
        TripInfo tripInfo = TrainTripService.populateTripInfo(stationGateRecord2, stationGateRecord1);

        TripInfo expected = new TripInfo("D","A",1572242400,240,2,1);

        Assert.assertEquals(expected, tripInfo);

    }
}
