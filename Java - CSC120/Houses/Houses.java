import java.util.Scanner;
//=============================================================================
public class Houses {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//-----------------------------------------------------------------------------
    public static void main(String[] args) {
int[] houseNumbers;
int[][] houseAges;
int numberOfHouses, numberOfPeople, personAge, houseTotal;

System.out.print("How many houses in the street?     : ");
numberOfHouses = keyboard.nextInt();

houseNumbers = new int[numberOfHouses];

System.out.println();

for (int index = 0; index < numberOfHouses; index++){
System.out.print("What is the next house number?     : ");
houseNumbers[index] = keyboard.nextInt();
}



houseAges = new int[numberOfHouses][];

System.out.println();


//
for (int house = 0; house < numberOfHouses; house++){

System.out.print("How many people live in house " + houseNumbers[house] + "?   : " );
numberOfPeople = keyboard.nextInt();
houseAges[house] = new int[numberOfPeople];


//loop in loop asks what age is person in house is

for (int person = 0; person < numberOfPeople; person++){
System.out.print("What is the age of person " + (person + 1) + "?       : " );
houseAges[house][person] = keyboard.nextInt();

}}

System.out.println();


//Gathers  and displays total age of house
for (int i = 0; i < houseAges.length; i++){

  houseTotal = 0;

for (int j = 0; j < houseAges[i].length;j++){


houseTotal += houseAges[i][j];

}

System.out.println("House " + houseNumbers[i] + " has a total age of " + houseTotal);

}




int streetTotal = 0;

for (int i = 0; i < houseAges.length; i++){


for (int j = 0; j < houseAges[i].length;j++){


streetTotal += houseAges[i][j];

}}


System.out.println("The street has a total age of " + streetTotal);







  







//












    }
//-----------------------------------------------------------------------------
   }
//=============================================================================


