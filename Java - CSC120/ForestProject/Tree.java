//Jose Fernandez
import java.io.*;

public class Tree implements Serializable
{
	private static double MIN_HEIGHT = 1.0;
	private static double MAX_HEIGHT = 4.0;
	private static double MIN_GROWTH = 50.0;
	private static double MAX_GROWTH = 50.0;


	private double height;
	private double growthRate;

public Tree(){

		height = ((Math.random()*MAX_HEIGHT)+MIN_HEIGHT);

		growthRate = ((Math.random()*MAX_GROWTH) + MIN_GROWTH);

	}

public Tree(double height, double growthRate){

		this.height = height;

		this.growthRate = growthRate;



	}


public String toString(){

		return (String.format("%6.2f  (%2d%% pa) \n", height,
		Math.round((float)growthRate)));


	}


public double getHeight() {
	return (height);

	}

public double getGrowthRate(){

	return (growthRate);

}




public void treeGrowth(){


	height = height * (1+ (growthRate/100));


}



}

