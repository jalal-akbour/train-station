package fr.train_station.main;

import fr.train_station.entities.CustomersInfo;
import fr.train_station.entities.StationGateRecord;
import fr.train_station.services.TrainTripService;
import java.io.IOException;
import java.util.List;

public class AppLaunch {

    /**
     * java AppLaunch "src/test/resources/inputFile.json" "src/test/resources/customerSummaries.json"
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        TrainTripService trainTripService = new TrainTripService();
        String inputFilePath = args[0];
        String outputFilePath = args[1];
        List<StationGateRecord> stationGateRecords = trainTripService.mapJsonToCustomersInfoList(inputFilePath);
        List<CustomersInfo> customersInfo = trainTripService.getMultipleCustomerInfo(stationGateRecords);
        trainTripService.customerSummariesFileGeneration(outputFilePath, customersInfo);
    }
}
