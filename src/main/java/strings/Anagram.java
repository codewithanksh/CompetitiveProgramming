package strings;

public class Anagram {


    static boolean isAnagram(String s1, String s2){

        if (s1.length() != s2.length())
            return false;

        char[] ch = new char[256];

        System.out.println(ch[0]);

        for(int i=0; i < 256; i++) {
            ch[i] = 0;
        }

        for(int i=0; i < s1.length(); i++) {
            char curr = s1.charAt(i);
            ch[curr] += 1;
        }

        for(int i=0; i < s2.length(); i++) {
            char curr = s2.charAt(i);
            ch[curr] -= 1;
        }

        for(int i=0; i < 256; i++) {
            if(ch[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "keepi";
        String s2 = "pekie  ";

        boolean result = isAnagram(s1,s2);

        System.out.println("Result "+result);
    }
}
