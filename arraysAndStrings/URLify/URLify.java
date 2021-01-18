public class URLify {
    // write a method to replace all spaces in a string with %20
    // use a char array so it can be done in place
    // TRUE length is given
    // input : "Mr John Smith       ", 13
    // output: "Mr%20John%20Smith%20"      

    public static char[] urlify(String str){

        char[] s = str.toCharArray();

        int strSize = s.length;

        // find last non-space
        int lastIndex = 0;

        for (lastIndex = strSize-1; lastIndex >= 0; lastIndex--){
            if( s[lastIndex] != ' '){
                break;
            }
        }

        int extraSpots = strSize - lastIndex - 1;

        for (int i = 0; i < strSize - extraSpots; i++){
            if (s[i] == ' '){
                for (int h = i; h < strSize - extraSpots; h++){
                    if (s[h] == ' '){
                        s = insert20(i, extraSpots, s);
                    }
                    break;
                }
            }
        }

        return s;
    }

    public static char[] insert20(int start, int extraSpots, char[] cArr){

        int end = cArr.length;

        char[] inserts = new char[]{'%','2','0'};

        for (int h = 0; h < 2; h++){
            for (int i = end; i >= start; i--){
                if (i+1 < cArr.length){
                    cArr[i+1] = cArr[i];
                }
            }
        
            start++;
            end++;        
        }

        int counter = 0;

        for (int i=start - 2; i <= start; i++){
            cArr[i] = inserts[counter];
            counter++;
        }
    
        return cArr;
    }


    public static void main(String[] args){

        String s = "Jamel Hendricks  ";

        System.out.print("'");
        System.out.print(s);
        System.out.println("'");
        System.out.print("'");
        System.out.print(urlify(s));
        System.out.println("'");

        s = "sample sentence here to test multiple          ";
        System.out.print("'");
        System.out.print(s);
        System.out.println("'");
        System.out.print("'");
        System.out.print(urlify(s));
        System.out.println("'");
    }
}