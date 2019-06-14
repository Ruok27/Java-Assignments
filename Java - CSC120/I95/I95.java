import java.util.Scanner;
//=============================================================================
public class I95 {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    private static final int SPEED_LIMIT = 65;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

    double miles, hours, speed;
    boolean limit = true;

//Displays welcome and instructions, uses no values
    Welcome();

//Prompts user for input
    System.out.print("Enter distance to travel : ");
    miles = keyboard.nextDouble();
    System.out.print("Enter time to travel : ");
    hours = keyboard.nextDouble();

//Computes intial speed value without rest 
    speed = Compute(miles, hours);

//Displays results 
    Display(speed, limit);

    }
//-----------------------------------------------------------------------------
    private static void Welcome() {

    System.out.println("Welcome to the I95 Speed Machine\n");
    System.out.println("You will have to supply: ");
    System.out.println("+ The distance you want to travel, in miles");
    System.out.println("+ The time you have available, in hours");
 
    }
//-----------------------------------------------------------------------------

    private static double Compute(double miles, double hours) {

    double speed, stops, rest, distance;


//Computes time for stops
    stops = miles / 100;

    if ((miles % 100)!= 0)

{
    stops = Math.ceil(stops);
}

    rest = ((stops * 5) / 60);

//Computes time for travel

    distance = hours - rest;


//Computes the speed 

    speed =  miles / distance;
 

    return speed;
   
 }



//-----------------------------------------------------------------------------
    private static void Display(double speed, boolean limit) {



    System.out.println("\nYou will have to travel at " + speed + "mph");

    if (speed >= SPEED_LIMIT){

    limit = true;

}

    else limit = false;


    System.out.println("Over the speed limit : " + limit);


 
    }
//-----------------------------------------------------------------------------

}

//=============================================================================

