package strings;

/***
 * Given a balanced string str of size N with an equal no of L and R,
 * the task is to find a maximum number X, such that the given string
 * can be partitioned into X balanced substring.
 *
 * A string is called balanced when number of L's in the string is same is
 * number of R's
 */

public class BalancedStringProblem {

    static int countR, countL;

    //LR
    static int findBalancedSubStrings(String s) {

        if (s.length() == 0 || s.length() % 2 != 0)
            return 0;

        int balancedSubStrings = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'L') {
                sb.append('L');
                countL++;
            } else {
                sb.append('R');
                countR++;
            }

            if (countL == countR) {
                System.out.println(sb.toString());
                countL = 0;
                countR = 0;
                sb = new StringBuilder();
                balancedSubStrings++;
            }


        }

        return balancedSubStrings;
    }

    public static void main(String[] args) {

        String s = "LRLLRRLRRL";
        System.out.println("No of valid substrings: " + findBalancedSubStrings(s));
    }
}
