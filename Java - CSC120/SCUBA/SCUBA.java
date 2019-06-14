//Jose Fernandez
import java.util.Scanner;
public class SCUBA 
{
    
    private static Scanner keyboard = new Scanner(System.in);
    private static double FTPERATMO= 33;
    
    public static void main(String[] args) 
    {
        
        double depth, percentO2;
          double ambientPress, partPress;
	boolean maxPress, continPress;
	  char group;

        //Requests input data 
        System.out.print("Enter Depth and Percentage O2: ");
          depth = keyboard.nextDouble();
          percentO2= keyboard.nextDouble();

	//preforms program calculations
            
	ambientPress = (depth / FTPERATMO) + 1;
	partPress = (percentO2 / 100) * ambientPress;
	
	
	//assigns O2 Group
	if (partPress >= 0.0 AND partPress < 0.1) {
	 group = 'A';
	
	} else if (partPress >= 0.1 AND partPress < 0.2) {
         group = 'B';
        
        } else if (partPress >= 0.2 AND partPress < 0.3) {
         group = 'C';

	} else if (partPress >= 0.3 AND partPress < 0.4) {
         group = 'D';
	
	} else if (partPress >= 0.4 AND partPress < 0.5) {
         group = 'E';

	} else if (partPress >= 0.5 AND partPress < 0.6) {
         group = 'F';
	
	} else if (partPress >= 0.6 AND partPress < 0.7) {
         group = 'G';

	} else if (partPress >= 0.7 AND partPress < 0.8) {
         group = 'H';

	} else if (partPress >= 0.8 AND partPress < 0.9) {
         group = 'I';

	} else if (partPress >= 0.9 AND partPress < 1.0) {
         group = 'J';

	} else if (partPress >= 1.0 AND partPress < 1.1) {
         group = 'K';

	} else if (partPress >= 1.1 AND partPress < 1.2) {
         group = 'L';

	} else if (partPress >= 1.2 AND partPress < 1.3) {
         group = 'M';

	} else if (partPress >= 1.3 AND partPress < 1.4) {
         group = 'N';





	// Maximal pressure
	if (partPress >= 1.4)
	{
	maxPress= TRUE;
	}

	else
	
	maxPress=  FALSE;

	
	//Contingency pressure
	
	if (partPress >= 1.6)
	{
	continPress = TRUE;
	}

	else
	
	continPress = FALSE;


	
	
           
                 
           
          System.out.println("Depth and Percentage O2: " + depth + percentO2);
          System.out.println("Ambient pressure: " + ambientPress);
          System.out.println("O2 pressure: " + partPress);
        //System.out.println("O2 group" + group)
        //System.out.println("Exceeds maximal O2 pressure: " + maxPress);
        //System.out.println("Exceeds contingency O2 pressure: " + continPress);

    }  
}
          
         