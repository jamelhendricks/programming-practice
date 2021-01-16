import java.lang.StringBuilder;
import java.util.Arrays;


public class MatrixRotation {

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


    public static int[][] rotateArray(int[][] array){
        int length = array[0].length; 
        int[][] rotated = new int[length][length];

        int[] oneByForm = new int[length * length];
        int counter = 0;
        for (int i = 0; i < length; i++){
            for (int h = 0; h < length; h++){
                oneByForm[counter] = array[i][h]; 
                counter++;
            }
        }
 
	    counter = 0;
        for (int i = 0; i < length; i++){
            for (int h = length - 1; h >= 0; h--){  
                rotated[h][i] = oneByForm[counter];
                counter++;
            }
        }

	    return rotated;
    }
 
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

    public static void naiveMethod(){
        printBySide(oneBy, rotateArray(oneBy));
        printBySide(twoBy, rotateArray(twoBy));
        printBySide(threeBy, rotateArray(threeBy));
        printBySide(fourBy, rotateArray(fourBy)); 
    }

    public static void main(String[] args){
	    naiveMethod();
    }
}
