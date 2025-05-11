import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {
//        Clock digitalClock = new DigitalClock(true);
//        digitalClock.setTime(00, 00, 00);
//        System.out.println(digitalClock);
//        Map<String, City> cites = City.parsFile("/home/natalia/kolos2024/src/strefy.csv");
//        System.out.println(cites);
//        Clock digitalClock2 = new DigitalClock(true);
//        digitalClock2.setCity(cites.get("Warszawa"));
//        digitalClock2.setTime(17, 00, 00);
//        digitalClock2.setCity(cites.get("Los Angeles"));
//        System.out.println(digitalClock2);
//        LocalTime localTime = LocalTime.of(12, 00, 00);
//        cites.values().forEach(city -> {
//            LocalTime localMeanTime = city.localMeanTime(localTime, city);
//            System.out.println("city: " + city.getCapital() + ", time " + localMeanTime);
//        });
//        System.out.println("PO SORTOWANIU ");
//        //System.out.println(Arrays.sort(cites.values(), City.worstTimezoneFit());
//        List<City>sortedCities = new ArrayList<>(cites.values());
//        sortedCities.sort(City.worstTimezoneFit());
//        System.out.println(sortedCities);
//            City city = new City("Bratysława",2,"48.1486 N", "17.1077 E" );
//            AnalogClock analogClock = new AnalogClock(city);
//            analogClock.setTime(13, 23, 8);
        List<City> cities = Arrays.asList(
                new City("Bratysława", 2, "48.1486 N", "17.1077 E"),
                new City("Warszawa", 2, "52.2297 N", "21.0122 E"),
                new City("Wellington", 12, "40.9006 S", "174.8860 E")
        );

        AnalogClock analogClock = new AnalogClock(cities.get(0));
        analogClock.setTime(15, 0, 0);

        try {

            City.generateAnalogClocksSvg(cities, analogClock);
            System.out.println("Pliki zostały zapisane.");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd przy zapisie plików SVG.");
            e.printStackTrace();
        }
    }

}


