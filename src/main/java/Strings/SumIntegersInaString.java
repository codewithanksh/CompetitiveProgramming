package Strings;

/**
 * Given a Alpha numeric string, compute sum of all integers available in the string
 * <p>
 * Tr2th34hfg1th263
 */
public class SumIntegersInaString {

    static int computeSum(String s) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }

            if (sb.length() > 0) {
                sum = sum + Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "Tr2th34hfg1th263";
        System.out.println(computeSum(s));

        s = "1a2b3c4d";
        System.out.println(computeSum(s));
        //computeSum_(s);
    }
}
