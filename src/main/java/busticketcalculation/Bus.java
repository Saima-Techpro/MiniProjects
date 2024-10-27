package busticketcalculation;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    // busNum, seatNo;

    public String busNum;

    public List<String> seats = new ArrayList<>();

    public Bus(String busNum) {  // constructor
        this.busNum = busNum;
// to ensure the bus has 32 seat, we create a list and store these seats
        for (int i=1; i<33; i++){
            this.seats.add(i +"");
        }
    }

}
