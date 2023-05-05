package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path filePath, Car car) {
        try {
            Files.writeString(filePath, car.serialize(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path filePath) {
        try {
            String jsonRepresentation = Files.readString(filePath);
            return Car.unserialize(jsonRepresentation);
        } catch (IOException e)    {
            e.printStackTrace();
        }
        return null;
    }
}
// END
