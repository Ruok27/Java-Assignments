//Jose Fernandez
import java.io.*;

public class Forest implements Serializable
{

	private static final int TREE_LIMIT = 10;
	private String name;
	private Tree [] muhForest;


public Forest(){

		name = null;
		muhForest = new Tree[TREE_LIMIT];



		for (int i = 0; i < muhForest.length; i++)
		{
			muhForest[i] = new Tree();
		}


	}


public Forest(String newName){

		this();
		name = newName;

	}

public void grow(){

	double newHeight = 0.0;

	for (int i = 0; i < muhForest.length; i++)
	{
		muhForest[i].treeGrowth();
	}


	}




public double reap(double cut){

	double newHeight = 0.0;

	for (int i = 0; i < muhForest.length; i++)

	{
		if (muhForest[i].getHeight() >= cut){
			System.out.printf("Cut %2d : %6.2f  (%2.0f%% pa) \n", (i+1),
				muhForest[i].getHeight(), muhForest[i].getGrowthRate());

			muhForest[i] = new Tree();
			System.out.printf("New %2d : %6.2f  (%2.0f%% pa) \n", (i+1),
				muhForest[i].getHeight(), muhForest[i].getGrowthRate());

		}


	}


			return (newHeight);
			}

public void display(){

	for (int i = 0; i < muhForest.length; i++)
	{
		if (muhForest[i] != null){
			System.out.printf("%2d  :  %5s\n", (i+1),muhForest[i]);
		}
	}

}


public boolean save(String name) {

		ObjectOutputStream toStream = null;
		int trees;

		try {
			toStream = new ObjectOutputStream(new FileOutputStream(name));

			for (trees = 0; trees < muhForest.length; trees++) {
				if (muhForest[trees] != null) {
					toStream.writeObject(muhForest[trees]);
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR: Saving forest : " + e.getMessage());
			return(false);
		} finally {
			try {
				if (toStream != null) {
					toStream.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
				return(false);
			}
		}
		return(true);
	}

//---------------------------------------------------------------------------

public boolean load(String name) {

		ObjectInputStream fromStream;
		Tree nextTree;
		int numberOfTrees;

		numberOfTrees = 0;
		fromStream = null;
		try {
			fromStream = new ObjectInputStream(new FileInputStream(name));
			nextTree = (Tree)fromStream.readObject();
			while (nextTree != null) {
				muhForest[numberOfTrees] = nextTree;
				numberOfTrees++;
				nextTree = (Tree)fromStream.readObject();
			}
		} catch (EOFException e) {
		} catch (IOException e) {
			System.out.println("ERROR: Loading trees: " + e.getMessage());
			return(false);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return(false);
		} finally {
			try {
				if (fromStream != null) {
					fromStream.close();
				}
			} catch (IOException e) {
				System.out.println("ERROR: Closing file: " + e.getMessage());
				return(false);
			}
		}
		System.out.println("The forest: " + name +
" has been successfully loaded!");
		return(true);
	}

//---------------------------------------------------------------------------






























	}

