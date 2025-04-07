import java.time.format.DateTimeFormatter;

public class DigitalClock extends Clock {
    private final boolean is24HourClock;
    private static DateTimeFormatter time12Formatter = DateTimeFormatter.ofPattern("h:mm:ss a");

//    public DigitalClock() {
//        is24HourClock = true;
//    }

    public DigitalClock(boolean is24HourClock) {
        this.is24HourClock = is24HourClock;
    }

    @Override
    public String toString() {
        if (is24HourClock) {
            return super.toString();
        }
        return display12HourFormat();
    }

    private String display12HourFormat() {
    return getCurrentTime().format(time12Formatter);
    }
}
