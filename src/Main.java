import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Clock digitalClock = new DigitalClock(true);
        digitalClock.setTime(00, 00, 00);
        System.out.println(digitalClock);
        Map<String, City> cites = City.parsFile("/home/natalia/kolos2024/src/strefy.csv");
        System.out.println(cites);
//        Clock digitalClock2 = new DigitalClock(true);
//        digitalClock2.setCity(cites.get("Warszawa"));
//        digitalClock2.setTime(17, 00, 00);
//        digitalClock2.setCity(cites.get("Los Angeles"));
//        System.out.println(digitalClock2);
        LocalTime localTime = LocalTime.of(12, 00, 00);
        cites.values().forEach(city -> {
            LocalTime localMeanTime = city.localMeanTime(localTime, city);
            System.out.println("city: " + city.getCapital() + ", time " + localMeanTime);
        });
//        System.out.println("PO SORTOWANIU ");
//        //System.out.println(Arrays.sort(cites.values(), City.worstTimezoneFit());
//        List<City>sortedCities = new ArrayList<>(cites.values());
//        sortedCities.sort(City.worstTimezoneFit());
//        System.out.println(sortedCities);
    }
}