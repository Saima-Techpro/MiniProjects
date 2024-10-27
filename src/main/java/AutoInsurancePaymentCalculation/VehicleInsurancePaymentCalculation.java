package AutoInsurancePaymentCalculation;

import java.util.Scanner;

public class VehicleInsurancePaymentCalculation {

       /*
       Project: Auto Insurance Payment Calculator
       Vehicle types: car, truck, bus, motorcycle
                     -bus: 18-30 seats or 31 and above seats
      Tariff period: December 2023, June 2023
      1st term: June 2023                      2nd term: December 2023
         cars: 2000                            cars: 2500
         truck: 3000                           truck: 3500
         bus: type1: 4000 type2: 5000          bus: type1: 4500,  type2: 5500
         motorcycle: 1500                      motorcycle: 1750
       In case of incorrect entry, the "Calculation failed" warning should be given to the user and the menu should be shown again.
       To be able to let user restart, we should present option to restart
*/

    public static void main(String[] args) {

        startCalculation();

    }

    // Create our own method
    public static void startCalculation(){

        Scanner input=new Scanner(System.in);

        boolean isFailed;

        do {
            isFailed=false;
            System.out.println("---Calculation for Vehicle Insurance---"+"\nChoose a term for payment calculation: ");
            System.out.println("1- June 2023");
            System.out.println("2- December 2023");

            int term= input.nextInt();

            //if the term entered correctly, the process should go on
            if (term==1 || term==2){

                Vehicle objVehicle=new Vehicle();  // to access the variables and methods from Vehicle class, we create its object
                System.out.println("Enter the type of vehicle for payment calculation: ");
                System.out.println("Car, Truck, Bus, Motorcycle");
                objVehicle.type= input.next().toUpperCase();

                objVehicle.payment=objVehicle.countPayment(term);

                //check if the payment is greater than 0, give a message to the user "Calculation Done! OR Insurance Details:"
                //if the payment is 0 or negative give a message to the user "Incorrect data entrance"

                String termName= term==1 ? "June 2023": "December 2023"; // create a ternary and store in local variable
                int select;
                if (objVehicle.payment>0){
                    System.out.println("Insurance Details: ");
                    System.out.println("Vehicle Type: "+ objVehicle.type);
                    // System.out.println(objVehicle.busType == 1 ? "Bus type 1: 18-30 seats" : "Bus type 2: 31 and above seats");
                    // To print term name, create a ternary and store in a local String variable termName
                    System.out.println("Term : "+ termName);
                    System.out.println("Payment due: " + objVehicle.payment);
                    // give option to restart if user wants to calculate insurance for another vehicle
                    System.out.println("To Restart Please Press 1, To Exit Please Press 0 ");
                    select= input.nextInt();

                    if(select==1) {
                        isFailed = true;
                    }else{
                        isFailed=false;
                    }

                }else{  // if payment is negative, warn user and ask user if he wants to restart the application
                    System.out.println("Incorrect data entrance");
                    System.out.println("To Restart Please Press 1, To Exit Please Press 0: ");
                    select= input.nextInt();
                    if (select==1){
                        isFailed=true;

                    }else {

                        isFailed=false;
                    }


                }



            }else{  //if the term entered incorrectly, user should get a warning message

                System.out.println("Incorrect data. Calculation failed!!");
                isFailed=true;

            }



        }while (isFailed);



    }


}
