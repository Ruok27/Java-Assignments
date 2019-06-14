import java.util.Scanner;
//=============================================================================
public class RooKill {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----Roadkill probability constant
    private static final double ROO_PROB= 1.47;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold values
        double square,roadWidth,rooNum, rooDensity,rooKill;

//----Gather data
        System.out.print("Enter side of square in km    : ");
        square = keyboard.nextDouble();
	System.out.print("Enter road length in km       : ");
	roadWidth = keyboard.nextDouble();
	System.out.print("Enter number of 'roos         : ");
	rooNum = keyboard.nextDouble();

//----Perform calculation
        square = square * square;
	rooDensity = rooNum / square;
	rooKill = rooDensity/roadWidth*ROO_PROB;

//----Display results
        System.out.println("Expected number of kills is   : " + rooKill);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================

