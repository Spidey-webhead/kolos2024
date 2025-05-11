import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AnalogClock extends Clock{
    private final List<ClockHand> hands = List.of(
            new HourHand(),
            new MinuteHand(),
            new SecondHand()
    );
    public AnalogClock(City city){
        super(city);
    }
    @Override
    public void setTime(int hour, int minute, int second) throws IllegalAccessException {
        super.setTime(hour, minute, second); // ustawia currentTime
        for (ClockHand hand : hands) {
            hand.setTime(currentTime); // każda wskazówka aktualizuje swój kąt
        }
    }
    public void toSvg(String filePath) throws IOException{
        FileWriter writer = new FileWriter(filePath);
        writer.write("<svg width=\"200\" height=\"200\" viewBox=\"0 0 200 200\" " +
                "xmlns=\"http://www.w3.org/2000/svg\">\n");
        //tarcza zegara
        writer.write("<circle cx=\"100\" cy=\"100\" r=\"90\" " +
                "stroke=\"black\" stroke-width=\"4\" fill=\"white\" />\n");
        for(ClockHand hand : hands){
            writer.write(hand.toSvg() + "\n");
        }
        writer.write("</svg>");
        writer.close();
    }


}


