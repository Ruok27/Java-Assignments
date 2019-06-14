package lab01;

public class SumExperiment {
	
	public static int check_sum(int[] array){
		// This function will inspect the input to find any pair of values that add up to 20
		// if it find such a pair, it will return the *index* of the smallest value
		// if it does not find such as pair, it will return -1;
		// remove the following line after you are done writing the function
		
		
		//defines pointers
		int i = 0;
		//subtract 1 from length to avoid bounds error
		int j = array.length - 1;
		
		//sum of both pointer's values
		int num = array[i] + array[j];
		
		//Keep checking until a correct pair is found
		while (num!= 20){
			
			
		if (num == 20){		
			
			return i;
		}		
		
		
		
		else if (num > 20){
			j--;
			}
		
			
		else if (num < 20){
			i++;
			}
		//Reinitialize sum so loop can continue 
		num = array[i] + array[j];
		
		
		}
		
		//Because the index cannot be -1 the return value has to be explicitly stated
		if (i==j){
			
			return -1;
		}		
		
		return i;
	}
				
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (check_sum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (check_sum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (check_sum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (check_sum(array4) != -1)
			System.err.println("TEST4 FAILED");
		
		System.out.println("Done!!!");
	}
}
