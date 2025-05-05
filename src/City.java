import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class City {
    private String capital;
    private int timeZone;
    private String latitude;
    private String longitude;

    private static final int GEOGRAPHIC_SECONDS = 240;
    private static final int GEOGRAPHIC_MINUTES = 15;

    public City(String capital, int timeZone, String latitude, String longitude) {
        this.capital = capital;
        this.timeZone = timeZone;
        this.latitude = latitude.trim();
        this.longitude = longitude.trim();
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

    private static City parseLine(String input) {
        String[] parts = input.split(",");
        return new City(parts[0], Integer.valueOf(parts[1]), parts[2], parts[3]);
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

    //Rozwiazanie zadania nr 5:
    //1. ustalenie czasu UTC - czyli zadany czas np. 12.00 plus (E)/minus (
    // W) liczba godzin wynikajaca ze strefy czasowej
    // do czasu UTC dodajem (E) / odejmujemy (W) liczbe minut obliczona
    // ze wzrodu wspl. geograficzne * 4 minuty (4 min per stopien)
//    Zadanie 6. Podobnie jak 5, bedziemy potrzebowac czas zadany i czas wynikajacy z wsp. geograficznych. Nastepnie obliczmy roznice w minutach:
//
//    LocalTime start = LocalTime.of(9, 30);
//    LocalTime end   = LocalTime.of(11, 45);
//    long minutesDiff = Duration.between(start, end).toMinutes();
        public LocalTime localMeanTime(LocalTime inputTime, City city) {
        System.out.println(this);
            String[] longToTheParts = longitude.split(" "); @Ex!`Q1qZWAEZ
            double realLongitude = Double.valueOf(longToTheParts[0]);
        LocalTime UTCtime = inputTime.minusHours(this.timeZone);
        double secondDelta = GEOGRAPHIC_SECONDS * realLongitude;
        if("E".equals(longToTheParts[1])){
            return UTCtime.plusSeconds((long) secondDelta);
        }else{
                return UTCtime.minusSeconds((long) secondDelta);
        }

    }

    @Override
    public String toString() {
        return "City{" +
                "capital='" + capital + '\'' +
                ", timeZone=" + timeZone +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    private static double calculateLongitudeDelta(City city) {
        double longitudeDelta;
        String[] longToTheParts = city.longitude.split(" ");
        double realLongitude = Double.valueOf(longToTheParts[0]);
        if (city.timeZone >= 0) {
            if ("W".equals(longToTheParts[1])) {
                longitudeDelta = city.timeZone * GEOGRAPHIC_MINUTES + realLongitude;
            } else {
                longitudeDelta = city.timeZone * GEOGRAPHIC_MINUTES - realLongitude;
            }
        } else {
            if ("E".equals(longToTheParts[1])) {
                longitudeDelta = city.timeZone * GEOGRAPHIC_MINUTES - realLongitude;
            } else {
                longitudeDelta = city.timeZone * GEOGRAPHIC_MINUTES + realLongitude;
            }
        }
        return longitudeDelta;
    }

    public static Comparator<City> worstTimezoneFit() {
        return (city2, city1) -> {
            double longitudeCity1 = calculateLongitudeDelta(city1);
            double longitudeCity2 = calculateLongitudeDelta(city2);
            return longitudeCity1 < longitudeCity2 ? -1 : (longitudeCity1 == longitudeCity2 ? 0 : 1);
        };

    }

}
