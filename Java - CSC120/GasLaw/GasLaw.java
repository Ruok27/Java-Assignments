import java.util.Scanner;
//=============================================================================
public class GasLaw {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----The gas constant in Joules/mole/K 
    private static double GasConstant = 8.3143; 
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double Volume,Moles;
        double pressure;

//----Gather data
        System.out.print("Enter volume, moles, temperature : ");
        Volume = keyboard.nextDouble();
        Moles = keyboard.nextDouble();
        Volume = keyboard.nextDouble();

//----Perform calculation
        pressure = Moles * GasConstant / Volume;

//----Display results
        System.out.println("Pressure is " +  pressure);
    }}
//-----------------------------------------------------------------------------
//=============================================================================

