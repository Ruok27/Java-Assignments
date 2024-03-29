package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){}
	
	// constructor 1 - Constructor for new zero matrix
	public Matrix(int rowDim, int colDim){
		numRows = rowDim;
		numColumns = colDim;
		
		data = new int [rowDim][colDim];
		
		for (int i= 0; i < rowDim; i++){
			{
				for (int j =0; j < colDim; j++){	
				
					data[i][j]= 0;			
				}
			}
			
		}		
		
	}
	
	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		/* 1) put the numRows to be the number of 1D arrays in the 2D array
		*  2) specify the numColumns and set it
		*  3) be careful of special cases you are supposed to handle them properly
		*  4) create a new matrix to hold the data
		*  5) copy the data over
		*/
		
		
		data = new int [numRows][numColumns];
		
		for (int i= 0; i < numRows; i++){
			{
				for (int j =0; j < numColumns; j++){	
				
					data[i][j]= 0;			
				}
			}
			
		}	
		
		
		
		
	}	
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return a String that represents this 
		 * 			matrix, as specified in the instruction for M1 - anything else IS NOT acceptable
		 */
		
		String arrayNums = "";
		
		for (int i= 0; i < numRows;i++){
			arrayNums += "\n";		
			
			for (int j=0; j < numColumns; j++){
				
				arrayNums += data[i][j];
			}
		}		
		arrayNums += "\n";
		
		return arrayNums; 
	
	}
	
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return the correct value
		 * 			after determining if this matrix is equal to the input matrix
		 */
		
		return (m==o); 
	}

	public Matrix times(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for multiplication, if not, return null.
		 *  If they are compatible, determine the dimensions of the resulting matrix, and fill it in with
		 *  the correct values for matrix multiplication
		 */
		return null; // placeholder
	}
	
	public Matrix plus(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for addition, if not, return null.
		 *  If they are compatible, create a new matrix and fill it in with
		 *  the correct values for matrix addition
		 */
		return null; // placeholder
	}
	
	
    
    public Matrix transpose()
    {
        /*
         * TODO: replace the below return statement with the correct code,
         */
    	
data = new int [numRows][numColumns];
		
		for (int i= 0; i < numRows; i++){
			{
				for (int j =0; j < numColumns; j++){	
				
					data[j][i]= data[i][j];			
				}
			}
			
		}
		
		return null;
 
    
    }
}
