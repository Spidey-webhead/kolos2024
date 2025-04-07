import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static java.util.Objects.nonNull;

public abstract class Clock {
    private LocalTime currentTime;
    private City city;
    private static DateTimeFormatter time24Fomater = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Clock(City city) {
        this.city = city;
    }

    protected Clock() {
    }

    public void setCurrentTime() {
        currentTime = LocalTime.now();
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setTime(int hour, int minute, int second) throws IllegalAccessException {
        validateInputData(hour, minute, second);

        currentTime = LocalTime.of(hour, minute, second);
    }


    public void setCity(City city) {
        updateTime(city);

        this.city = city;

    }

    private void updateTime(City newCity) {
        if (nonNull(this.city) && nonNull(currentTime) && this.city.getTimeZone() != newCity.getTimeZone()) {
            int timeDelta = newCity.getTimeZone() - this.city.getTimeZone();
            currentTime = currentTime.plusHours(timeDelta);
        }
    }

    @Override
    public String toString() {
        return currentTime.format(time24Fomater);
    }

    private void validateInputData(int hour, int minute, int second) throws IllegalAccessException {
        if (hour > 24 || hour < 0) {
            throw new IllegalAccessException("hour out of range");
        }
        if (minute > 60 || minute < 0) {
            throw new IllegalAccessException("minute out of range");
        }
        if (second > 60 || second < 0) {
            throw new IllegalAccessException("second out of range");
        }
    }

}
