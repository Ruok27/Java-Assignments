//Jose Fernandez
import java.util.Scanner;
import java.util.*;

public class ForestProject
{

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)
	{
		Forest myforest = null;
		char input;
		double cut;
		String name = null;
		String Filename = "ForestProject.txt";
		String temp = null;
		double height = 0.0;
		double growthRate = 0.0;
		String myinput;


		do
		{
			System.out.println("(D)isplay, (N)ew, (Y)ear, (R)eap, (S)ave, (L)oad, e(X)it : ");
			input = keyboard.next().charAt(0);
			input = Character.toUpperCase(input);



			switch(input){

								case 'D':
									try {
										if (name != null){
										System.out.println(name);
										}
										myforest.display();
									}  catch (NullPointerException e) {
										System.out.println("No forest");
									}
								break;

								case 'N':
									System.out.print("What is the forest name: " );
									name = keyboard.next();
									myforest = new Forest(name);
									System.out.println();
									break;

								case 'Y':
								myforest.grow();
								System.out.println();
								break;

								case 'R':
								try {
									System.out.println("What height to reap at: ");
									myinput = keyboard.next();
									cut = Double.parseDouble(myinput);
									myforest.reap(cut);
									} catch (NumberFormatException e) {
										System.out.println("ERROR: Invalid height");
									}
									keyboard.nextLine();
									System.out.println();
									break;

								case 'S':
								myforest.save(name);
								System.out.println();
								break;

								case 'L':
									System.out.println("What is the forest name? : ");
									temp =  keyboard.nextLine();
									Forest tempf = myforest;
									try {

										myforest = new Forest("temp");
										if (!myforest.load(temp)){
										throw(new Exception("Load error"));
									}

										name = temp;
										} catch (Exception e) {
											if (temp == null){

												myforest = null;
											}
											System.out.println("Forest can not be found");
										}
									System.out.println();
									break;

								case 'X':

								System.out.println("Goodbye");
								break;



								default:
								System.out.println("ERROR: Invalid option");
								System.out.println();
									break;
					}


		}

		while(input != 'X');






}

}