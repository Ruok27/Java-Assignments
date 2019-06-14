//Jose Fernandez
import java.util.Scanner;
import java.util.Arrays;

public class BandProject
{



       private static Scanner keyboard = new Scanner(System.in);
       private static int MAX_ROWS = 10;
       private static int MAX_POS = 8;
       private static double EXCEED_WEIGHT = 100.0;
       private static double MAX_PERSWEIGHT = 200.0;
       private static double MIN_PERSWEIGHT = 45.0;




       public static void main(String[] args)
          {
		char choice;
		char[] rowArray;
		int rows, postions;
		double[][] structure;





				  System.out.println("Welcome to the Band of the Hour");
				  System.out.println("-------------------------------");
				  System.out.print("Please enter number of rows: ");

	do {
				  	rows = keyboard.nextInt();
	if (rows < 0 || rows >= MAX_ROWS){
				  	System.out.print("ERROR: Out of range, try again: ");
			  	  }
 } while (rows < 0 || rows >= MAX_ROWS);

			 	 	rowArray = new char [rows];

			 	 	structure = new double [rows][];
	for(int i = 0; i < rowArray.length ; i++){
					rowArray[i]= (char)(i + (int)'A');
					System.out.print("Please enter number of positions in row " + rowArray[i] + " : ");
					postions = keyboard.nextInt();
	while (postions <=  0 || postions >= MAX_POS){
					System.out.print("ERROR: Out of range, try again: ");
					postions = keyboard.nextInt();
				}

			 structure[i] = new double[postions];
			 }
				System.out.println();


	do {
				System.out.print("(A)dd, (R)emove, (P)rint, e(X)it : ");
				choice = keyboard.next().charAt(0);
				choice = Character.toUpperCase(choice);
				while (choice != 'A' && choice != 'R' && choice != 'P' && choice != 'X'){
					System.out.print("ERROR: Invalid option, try again: ");
					choice = keyboard.next().charAt(0);
				}
				System.out.println();
				System.out.println();


				switch(choice){

					case 'A':
					addMethod(structure, rowArray);
					break;

					case 'R':
					removeMethod(structure, rowArray);
					break;

					case 'P':
					printMethod(structure);
					break;

					case 'X':
					break;

					default:
					if (choice != 'X'){
						break;
					}
				}
	} while (choice != 'X');

       }

//==========================================================
private static void addMethod  (double[][]structure, char[] rowArray){


	char rowLabel;
	int position, row;
	double weight = 0.0;
	double weightTotal = 0.0;
	double weightAverage= 0.0;



			System.out.print("Please enter row letter : ");
			rowLabel = keyboard.next().toUpperCase().charAt(0);
			row = (int)(rowLabel - 'A');
	while (row >= rowArray.length){
			System.out.print("ERROR: Out of range, try again : ");
			rowLabel = keyboard.next().toUpperCase().charAt(0);
			row = (int)(rowLabel - 'A');
	}
			System.out.print("Please enter position number (1 to " + structure[row].length+" ): ");
			position = keyboard.nextInt();

	while (position < 1 || position > structure[row].length) {
			System.out.print("ERROR: Out of range, try again : ");
			position = keyboard.nextInt();
	}



	while (structure[row][position-1]>0) {
			System.out.println("ERROR: There is already a musician there. ");
			System.out.println();
			return;
	}

			System.out.print("Please enter weight (45.0 to 200.0) : ");
			weight = keyboard.nextDouble();

	while (weight < MIN_PERSWEIGHT || weight > MAX_PERSWEIGHT){
			System.out.print("ERROR: Out of range, try again : ");
			weight = keyboard.nextDouble();
	}
			structure[row][position-1] = weight;
	for (int i = 0; i < structure[row].length ; i++){
			weightTotal += structure[row][i];
	}
			weightAverage = weightTotal / structure[row].length;

	if (weightAverage > EXCEED_WEIGHT){
			System.out.print("ERROR: That would exceed the average weight limit: ");
		    structure[row][position-1] = 0.0;
		    System.out.println();

			 return;

	}


			System.out.println("****** Musician added.");


			return;
}

//==========================================================
private static void removeMethod(double[][]structure, char[] rowArray){

	int position, row;
	char rowLabel;

			System.out.print("Please enter row letter : ");
			rowLabel = keyboard.next().toUpperCase().charAt(0);
			row = (int)(rowLabel - 'A');
		while (row >= rowArray.length){
			System.out.print("ERROR: Out of range, try again : ");
			rowLabel = keyboard.next().toUpperCase().charAt(0);
			row = (int)(rowLabel - 'A');

	}

			System.out.print("Please enter position number (1 to " + structure[row].length + " ): ");
			position = keyboard.nextInt();

		while (position < 1 || position > structure[row].length) {
			System.out.print("ERROR: Out of range, try again : ");
			position = keyboard.nextInt();
	}
		while (structure[row][position-1] == 0) {
			System.out.println("ERROR: That position is vacant. ");
			System.out.println();
			return;
	}

			structure[row][position-1] = 0;
			System.out.print("****** Musician removed.");
			System.out.println();
			return;
}
//==========================================================
private static void printMethod (double[][]structure){

	double num = 0;

for (int i = 0; i < structure.length; i++){
			System.out.print((char)(65 + i) + ": ");
for (int j = 0; j <= MAX_POS; j++){
	if (structure[i].length > j){
			System.out.printf("%6.1f,", structure[i][j]);
		num += structure[i][j];}

	else {
		System.out.print("      ");
		}
}
		System.out.printf("[%3.1f, "
					+ "%3.1f]%n", num, ((num/(structure[i].length))));
					num = 0;
				}
		System.out.println();

}










//==========================================================


}
