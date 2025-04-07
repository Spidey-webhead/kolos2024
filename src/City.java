import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.Function;
import java.util.stream.Collectors;

public class City {
    private String capital;
    private int timeZone;
    private String latitude;
    private String longitude;

    public City(String capital, int timeZone, String latitude, String longitude) {
        this.capital = capital;
        this.timeZone = timeZone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCapital() {
        return capital;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    private static City parseLine(String input){
        String [] parts = input.split(",");
        return new City(parts[0], Integer.valueOf(parts[1]) , parts[2], parts[3]);
    }
    public static Map<String, City> parsFile(String path) throws IOException, IllegalAccessException {
        if (Files.exists(Path.of(path))) {
            List<String> lines = Files.readAllLines(Path.of(path));

            return lines.stream()
                    .skip(1)
                    .map(line -> parseLine(line))
                    .collect(Collectors.toMap(City::getCapital, Function.identity()));
        }
        throw new IllegalAccessException("file do not exist");
    }
    public LocalTime localMeanTime(LocalTime inputTime) {
        String[] longToTheParts = longitude.split(" ");
        double realLongitude = Double.valueOf(longToTheParts[0]);
    }
}
