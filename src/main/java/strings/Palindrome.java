package strings;

public class Palindrome {


    static boolean isPalindrome(String s) {

        if(s.length() == 0)
            return false;

        int low = 0, high = s.length() - 1;

        while (low < high) {

            if(s.charAt(low) != s.charAt(high))
                return false;

            low++;
            high--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "1331";
        System.out.println(isPalindrome(s));
    }
}
