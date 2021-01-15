import java.lang.StringBuilder;


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

    public static void main(String[] args){
	prettyPrintArray(twoBy);
    }
}
