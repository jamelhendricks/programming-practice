import java.lang.StringBuilder;
import java.util.Arrays;

public class MatrixRotation {

    /*
        Challenge Description:
        Rotate an NxN 2-d matrix counter-clockwise, one cycle.

        Example:
            [1][2]      [2][4]
            [3][4]      [1][3]
            original    rotated
    */


    // sample input arrays
    public static int[][] oneBy = new int[][]{
        {1}
    };

    public static int[][] twoBy = new int[][]{
        {1,2},
        {3,4},
    };

    public static int[][] threeBy = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    
    public static int[][] fourBy = new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}
    };

    public static void prettyPrintArray(int[][] array){
	    int length = array[0].length;
	    StringBuilder prettyArray = new StringBuilder();

        for (int i = 0; i < length; i++){
	        for (int h = 0; h < length; h++){
                String slot = "[ " + array[i][h] + " ] ";
		        prettyArray.append(slot);
            }
            
 	        prettyArray.append("\n");
        }

	    System.out.println(prettyArray.toString());
    }

    /* naive solution:
        breakdown:
            - converts 2d array to 1d array which takes N time and 2N space
            - reads 1d conversion array and assigns to new array in N time and N space
            - overall: 2N time and 3N sapce -> O(n) time, O(n) space

        post:
            - can probably combine the two for-loops to read the 1-d array and assign 
              in rotated array at the same time
            - would be nice if you didn't have to change into 1-d array at all
    */
    public static int[][] rotateArray(int[][] array){
        int length = array[0].length; 
        int[][] rotated = new int[length][length];

        int[] oneByForm = new int[length * length];
        int counter = 0;

        // store each element of 2d array in 1d array
        // time: O(n)
        for (int i = 0; i < length; i++){
            for (int h = 0; h < length; h++){ 
                oneByForm[counter] = array[i][h]; 
                counter++;
            }
        }
 
        counter = 0; // reset counter
        
        // essentially rewrite the array but from bottom to top, left to right
        // instead of left to right, bottom to top
        // time: O(n)
        for (int i = 0; i < length; i++){ 
            for (int h = length - 1; h >= 0; h--){ 
                rotated[h][i] = oneByForm[counter];
                counter++;
            }
        }

	    return rotated;
    }

    // optimal solution (constant space, in place)
    // CLOCKWISE !!!!!
    public static int[][] optimalSolution(int[][] array){

        int N = array[0].length;

        // swap corresponding opposite columns of a transposed array to do a clockwise rotation

        // transpose the array
        for (int i = 0; i < N; i++){
            for (int j = i; j < N; j++){
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        // swap the opposite rows, except the middle
        for (int i = 0; i < N; i++){
            for (int j = 0; j < (N/2); j++){
                int temp = array[i][j];
                array[i][j] = array[i][N-1-j];
                array[i][N-1-j] = temp;
            }
        }

        return array;
    }
    
    // helper method to pretty print two 2-d arrays side by side
    public static void printBySide(int[][] arrA, int[][] arrB){
	    int length = arrA[0].length;

        StringBuilder row = new StringBuilder();
        
	    row.append("----------------------------------------\n");        
        row.append("----------------------------------------\n\n");   
             
        for (int i = 0; i < length; i++){
            for (int h = 0; h < length; h++){
   	            row.append("[ " + arrA[i][h] + " ] "); 
            }
            
	        row.append("    |    ");

            for (int h = 0; h < length; h++){
   	            row.append("[ " + arrB[i][h] + " ] "); 
            }
            row.append("\n");
        }
        
        System.out.println(row.toString());
    }

    // run tests on sample inputs using naive solution
    public static void naiveMethod(){
        printBySide(oneBy, rotateArray(oneBy));
        printBySide(twoBy, rotateArray(twoBy));
        printBySide(threeBy, rotateArray(threeBy));
        printBySide(fourBy, rotateArray(fourBy)); 
    }

    public static void optimalMethod(){
        prettyPrintArray(oneBy);
        prettyPrintArray(optimalSolution(oneBy));
        prettyPrintArray(twoBy);
        prettyPrintArray(optimalSolution(twoBy));
        prettyPrintArray(threeBy);
        prettyPrintArray(optimalSolution(threeBy));
        prettyPrintArray(fourBy);
        prettyPrintArray(optimalSolution(fourBy));
    }

    public static void main(String[] args){
        // naiveMethod();
        optimalMethod();
    }
}
