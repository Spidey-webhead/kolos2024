import java.time.LocalTime;

public abstract class ClockHand {
    protected double angleInDegrees; //kat w stopniach - pozycja wskazowki
    public abstract void setTime(LocalTime time);
    public abstract String toSvg();


}
