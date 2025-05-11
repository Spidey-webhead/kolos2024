import java.time.LocalTime;

public class HourHand extends ClockHand{
    private static final int DEGREES_IN_CIRCLE = 360;
    private static final int HOURS_IN_DAY = 12;

    public void setTime(LocalTime time){
    this.angleInDegrees = ((time.getHour()%12) + time.getMinute()/60.0 + time.getSecond()/3600.0) *30*360;

    }

    @Override
    public String toSvg() {
        return  "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"50\" stroke=\"red\" stroke-width=\"2\" " +
                "transform=\"rotate(" + angleInDegrees + ", 100, 100)\" />";
    }
}
