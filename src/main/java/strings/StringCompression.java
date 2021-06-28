package strings;

/**
 * Input : aaaaabbbbbbcccc
 * Output : a5b6c4
 */
public class StringCompression {

    static String input = "aaaaabbbbbbccccdd";
    static String output = "";

    public static void main(String[] args) {
        computeOutput();
    }

    public static void computeOutput() {

        int count = 0;
        char currentChar;
        char oldChar = input.charAt(0);

        for (int i=0; i < input.length(); i++){

            currentChar = input.charAt(i);

            if(currentChar == oldChar) {
                count++;
            } else {
                System.out.printf("%c%d",oldChar,count);
                oldChar=currentChar;
                count=1;
            }

            if (i==input.length()-1)
                System.out.printf("%c%d",oldChar,count);
        }
    }
}
