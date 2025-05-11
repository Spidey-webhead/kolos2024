import java.time.LocalTime;

public class SecondHand extends ClockHand{
    private static final int SECONDS_IN_CIRCLE = 60;
    private static final int DEGREES_IN_CIRCLE = 360;

    @Override
    public void setTime(LocalTime time) {
        this.angleInDegrees = (time.getSecond()/SECONDS_IN_CIRCLE) * DEGREES_IN_CIRCLE;
        this.angleInDegrees= Math.toRadians(this.angleInDegrees);
    }

    public String toSvg(){
        return  "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"30\" stroke=\"red\" stroke-width=\"2\" " +
                "transform=\"rotate(" + angleInDegrees + ", 100, 100)\" />";

    }

}
