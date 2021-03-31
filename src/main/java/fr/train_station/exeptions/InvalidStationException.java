package fr.train_station.exeptions;

public class InvalidStationException extends IllegalAccessException{

    public InvalidStationException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidStationException() {
        super("Invalid Station Value");
    }
}
