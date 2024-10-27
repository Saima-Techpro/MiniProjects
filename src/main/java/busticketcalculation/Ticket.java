package busticketcalculation;

public class Ticket {
    // distance, journeyType, price, seatNum

    public double distance;
    public int journeyType;
    public double price;
    public int seatNum;

    public void printTicket(Bus bus){
        System.out.println(" --- Ticket Details ---");
        System.out.println("Bus No: "+ bus.busNum);
        System.out.println("Journey Type: " + (this.journeyType == 1 ?"One Way": "Round Trip"));
        System.out.println("Seat no: "+this.seatNum);
        System.out.println("Distance: " + this.distance + " km");
        System.out.println("Total Price: "+ this.price);
        System.out.println("Have a nice trip!");
    }

}
