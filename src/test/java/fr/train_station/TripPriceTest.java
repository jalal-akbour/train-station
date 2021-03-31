package fr.train_station;

import fr.train_station.exeptions.InvalidStationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import fr.train_station.services.TrainTripService;

@RunWith(MockitoJUnitRunner.class)
public class TripPriceTest {

    final TrainTripService TrainTripService = new TrainTripService();

    @Test
    public void should_return_240_when_tripFromZone1_toZone2() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("A", "D").tripPrice;
        Assert.assertEquals(240, price);
    }

    @Test
    public void should_return_240_when_tripFromZone2_toZone1() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("D", "B").tripPrice;
        Assert.assertEquals(240, price);
    }

    @Test
    public void should_return_200_when_tripFromZone3_toZone4() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("E", "I").tripPrice;
        Assert.assertEquals(200, price);
    }

    @Test
    public void should_return_200_when_tripFromZone4_toZone3() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("H", "E").tripPrice;
        Assert.assertEquals(200, price);
    }

    @Test
    public void should_return_280_when_tripFromZone3_toZone1() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("F", "A").tripPrice;
        Assert.assertEquals(280, price);
    }

    @Test
    public void should_return_280_when_tripFromZone3_toZone2() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("F", "D").tripPrice;
        Assert.assertEquals(280, price);
    }

    @Test
    public void should_return_300_when_tripFromZone4_toZone1() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("H", "A").tripPrice;
        Assert.assertEquals(300, price);
    }

    @Test
    public void should_return_300_when_tripFromZone4_toZone2() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("H", "D").tripPrice;
        Assert.assertEquals(300, price);
    }

    @Test
    public void should_return_280_when_tripFromZone1_toZone3() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("A", "F").tripPrice;
        Assert.assertEquals(280, price);
    }

    @Test
    public void should_return_280_when_tripFromZone2_toZone3() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("D", "F").tripPrice;
        Assert.assertEquals(280, price);
    }


    @Test
    public void should_return_300_when_tripFromZone1_toZone4() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("A", "G").tripPrice;
        Assert.assertEquals(300, price);
    }

    @Test
    public void should_return_300_when_tripFromZone2_toZone4() throws InvalidStationException {
        int price = TrainTripService.getPricingOfTrip("D", "I").tripPrice;
        Assert.assertEquals(300, price);
    }

    @Test(expected = InvalidStationException.class)
    public void should_ThrowException_when_tripFromInvalidStation() throws InvalidStationException {
        TrainTripService.getPricingOfTrip("?", "I");
    }

    @Test(expected = InvalidStationException.class)
    public void should_ThrowException_when_tripToInvalidStation() throws InvalidStationException {
       TrainTripService.getPricingOfTrip("D", "?");
    }
}
