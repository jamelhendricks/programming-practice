import java.util.HashMap;

public class IsUnique {
    // determine if a string has all unique characters

    public static boolean isUnique(String input){
        boolean unique = true;

        HashMap<Character, Integer> strMap = new HashMap<Character, Integer>();

        int strLength = input.length();
        for (int i = 0; i < strLength; i++){
            char c = input.charAt(i);

            if(strMap.keySet().contains(c)){
                return false;
            } else {
                strMap.put(c, 1);
            }
        }

        return unique;
    }


    public static void main(String[] args) {
        System.out.println("unique: " + isUnique("unique"));
        System.out.println("foo: " + isUnique("foo"));
        System.out.println("bar: " + isUnique("bar"));
        
    }
}