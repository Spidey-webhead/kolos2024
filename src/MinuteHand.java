import java.time.LocalTime;

public  class MinuteHand extends ClockHand{
    private static final int DEGREES_IN_CIRCLE = 360;


    public void setTime(LocalTime time){
        this.angleInDegrees = (time.getMinute()+ time.getSecond()/60.0) *30*360;

    }

    @Override
    public String toSvg() {

        return "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"40\"" +
                " stroke=\"blue\" stroke-width=\"3\" " +
                "transform=\"rotate(" + angleInDegrees + ", 100, 100)\" />";
    }
}
