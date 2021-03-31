package fr.train_station;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.train_station.entities.CustomersInfo;
import fr.train_station.entities.StationGateRecord;
import org.junit.Assert;
import org.junit.Test;
import fr.train_station.services.TrainTripService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReturnedFileTest {

    final TrainTripService trainTripService = new TrainTripService();


    @Test
    public void should_generateCustomerSummariesFile_when_ReadFrom_simpleInputFile() throws IOException {
        String inputFile = "src/test/resources/inputFile.json";
        List<StationGateRecord> stationGateRecords = trainTripService.mapJsonToCustomersInfoList(inputFile);

        String outputFile = "src/test/resources/customerSummaries.json";

        List<CustomersInfo> customersInfos = trainTripService.getMultipleCustomerInfo(stationGateRecords);
        trainTripService.customerSummariesFileGeneration(outputFile, customersInfos);

        String expectedReturnFile = "src/test/resources/expectedReturnFile.json";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedJsonNode = objectMapper.readValue(new File(expectedReturnFile), JsonNode.class);
        JsonNode outputJsonNode = objectMapper.readValue(new File(outputFile), JsonNode.class);

        Assert.assertEquals(expectedJsonNode,outputJsonNode);
    }
}
