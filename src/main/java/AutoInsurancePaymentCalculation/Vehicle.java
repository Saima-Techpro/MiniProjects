package AutoInsurancePaymentCalculation;

import java.util.Scanner;

public class Vehicle {

    /*
     Tariff period: December 2023, June 2023
      1st term: June 2023                      2nd term: December 2023
         cars: 2000                            cars: 2500
         truck: 3000                           truck: 3500
         bus: type1: 4000 type2: 5000          bus: type1: 4500 type2: 5500
         motorcycle: 1500                      motorcycle: 1750
     */

    public String type;
    public int payment;
    int busType;

    public int countPayment(int term){  // term will be given by the user
        // show basic if, if else() and else part(for incorrect data) of the statement and then add switch statement

        if (term==1){

            switch (type){
                case "CAR":
                    payment=2000;
                    break;
                case "TRUCK":
                    payment=3000;
                    break;
                case "BUS":
                    // create separate method for Bus coz there are two types of buses... nested switch is not recommended
                    countBusPayment(term);
                    break;
                case "MOTORCYCLE":
                    payment=1500;
                    break;
                default:
                    System.out.println("Incorrect data entrance");
                    payment=0;
                    break;
            }

        }else if(term==2){
            switch (type){
                case "CAR":
                    payment=2500;
                    break;
                case "TRUCK":
                    payment=3500;
                    break;
                case "BUS":
                    countBusPayment(term);
                    break;
                case "MOTORCYCLE":
                    payment=1750;
                    break;
                default:
                    System.out.println("Incorrect data entrance");
                    payment=0;
                    break;
            }

        }else{
            System.out.println("Incorrect input");
            payment=0;
        }

        return payment;
    }

    /*
     Tariff period: December 2023, June 2023
      1st term: June 2023                      2nd term: December 2023
         cars: 2000                            cars: 2500
         truck: 3000                           truck: 3500
         bus: type1: 4000 type2: 5000          bus: type1: 4500 type2: 5500
         motorcycle: 1500                      motorcycle: 1750
     */
    public int countBusPayment(int term){

        Scanner input= new Scanner(System.in);
        System.out.println("Enter the type of bus: ");
        System.out.println("Type 1: 18-30 seats"+"\nType 2: 31 and above seats");

        // int busType=input.nextInt();  create a local variable
        busType=input.nextInt();         // or create class variable and initiate it here

        switch (busType){
            case 1:  //if bus type = 1
                if(term==1) {
                    payment = 4000;
                }else{
                    payment=4500;
                }
                break;
            case 2: //if bus type = 2
                if(term==1){
                    payment=5000;
                }else {
                    payment=5500;
                }
                break;

        }
        return payment;
    }
     /*
    we can refine and improve our project even more by:
      1. adding discounts e.g. 10% less if you pay by this ....  date OR 25% less if you insure your car with us for 2 terms etc.
      2. we can add different calculations for cars (hybrid, electric, diesel etc.), for trucks (tow truck, trailer, flatbed truck  etc.) for motorcycles(heavy bike, mountain bike, hybrid bike etc.)
      3. discounts for registering more than one vehicles with us etc.

     */



}