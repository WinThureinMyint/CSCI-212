package lab1MyintW;


public class Matrix {
	
	// instance variables
	int [][] myMatrix;
	int row, col;
	Exception e;
	// Constructor
	public Matrix (int[][] m) {
		// TODO: Fill
		this.myMatrix = m;
		this.row = myMatrix.length;
		this.col = myMatrix[1].length;
	}
	
	// toString method
	public String toString() {
		// TODO: Represent the Matrix in a String format
		// Hint: How is an array printed?
		// DO NOT print directly in this method, meaning
		// don't use System.out.println here
		String matrixString = "";
		for(int i=0; i < this.row; i++){
			for(int j=0; j < col; j++){
				matrixString += (myMatrix[i][j] +"\t");
			}
			matrixString += "\n \n";
		}
		
		return matrixString;
	}
	
	// Addition
	public Matrix add(Matrix m) {
		// TODO: Add the two matrices, store the value
		// in a new matrix and return that matrix
		Matrix addMatrix = null;
		if(this.row == m.row && this.col == m.col) {
			addMatrix = new Matrix(new int[this.row][this.col]);
		       for (int i = 0; i < this.row; i++) {
		           for (int j = 0; j < this.col; j++) {
		        	   		addMatrix.myMatrix[i][j] = this.myMatrix[i][j] + m.myMatrix[i][j];
		           }
		       }
		}else {
			throw new RuntimeException("Illegal matrix dimensions because two matrices should have the same dimensions to add.");
		}
	   return addMatrix;
	}

	// Subtraction
	public Matrix sub(Matrix m) {
		// TODO: Subtract the two matrices, store the value
		// in a new matrix and return that matrix
		Matrix subMatrix=new Matrix(new int[this.row][this.col]);
		if(this.row == m.row && this.col == m.col) {
	       for (int i = 0; i < this.row; i++) {
	           for (int j = 0; j < this.col; j++) {
	        	   		subMatrix.myMatrix[i][j] = this.myMatrix[i][j] - m.myMatrix[i][j];
	           }
	       }
		}else {
			throw new RuntimeException("Illegal matrix dimensions because two matrices should have the same dimensions to subtract.");
		}
	    return subMatrix;
	}
	
	// Matrix Multiplication
	public Matrix mult(Matrix m) {
		// TODO: Multiply the two matrices, store the value
		// in a new matrix and return that matrix
		Matrix multMatrix=new Matrix(new int[this.row][m.col]);
		if(this.row == m.col ) {
	       for (int i = 0; i < this.row; i++) {
	           for (int j = 0; j < m.col; j++) {
	        	   		for (int k = 0; k < this.col; k++) { 
	        	   			multMatrix.myMatrix[i][j] += this.myMatrix[i][k] * m.myMatrix[k][j];
	        	   		}
	           }
	       }
		}else {
			throw new RuntimeException("Illegal matrix dimensions because Matrix A must have the same number of columns as the rows in Matrix B to multiply.");
		}
	   return multMatrix;
	}
	
	// Scalar Multiplication
	public Matrix mult(int scalar) {
		// TODO: Multiply the matrix with a scalar value
		// passed as a parameter
		// Store the value in a new matrix and return that matrix
		Matrix multMatrix=new Matrix(new int[this.row][this.col]);
		for(int i=0; i < this.row; i++){
			for(int j=0; j < col; j++){
				multMatrix.myMatrix[i][j] = 2*this.myMatrix[i][j];
			}
		}
		return multMatrix;
	}
	
	// Equal
	public boolean equal (Matrix m) {
		// TODO: Test whether two matrices are equal
		// Return true/false
		boolean equalMatrix=true;
		
		for(int i=0; i < this.row; i++){
			for(int j=0; j < col; j++){
				if(this.myMatrix[i][j] != m.myMatrix[i][j]) {
					equalMatrix=false;
				}
			}
		}
		return equalMatrix;
	}

	// Transpose
	public Matrix transpose() {
		// TODO: Transpose the matrix
		// Store the value in a new matrix and return that matrix
		Matrix transposeMatrix = new Matrix(new int[this.col][this.row]);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
            		transposeMatrix.myMatrix[j][i] = this.myMatrix[i][j];
            }
        }
	    return transposeMatrix;
	}
	
}
