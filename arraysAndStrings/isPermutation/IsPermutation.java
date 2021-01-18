import java.util.ArrayList;

public class IsPermutation {
    // check if string b is a permutation of string a 
    
    public static boolean isPermutation(String a, String b){
        int aLength = a.length();
        int bLength = b.length();

        if (aLength != bLength){
            return false;
        }

        ArrayList<Character> aList = new ArrayList<Character>();
        
        for (int i = 0; i < aLength; i++){
            aList.add(a.charAt(i));
        }

        for (int i = 0; i < bLength; i++){
            
            char currentChar = b.charAt(i);

            try {
                // must cast as a character, java will interpret it as the numeric value otherwise
                // and will liekly give you index out of bounds error (remove(int index) method)
                aList.remove((Character) currentChar);
            } catch (Exception e){
                // e.printStackTrace();
                return false;
            }
        }

        if (aList.size() > 0){
            return false;
        }

        return true;
    }


    public static void main(String[] args){
        System.out.println("abc  | abb : " + isPermutation("abc", "abb"));
        System.out.println("abc  | bac : " + isPermutation("abc", "bac"));
        System.out.println("fadf | a   : " + isPermutation("fadf", "a"));
    }
}