import java.util.HashMap;
import java.util.Map;

public class Demo {

    //Input: abbcccddddeeeee
    //Output: a1b2c3d4e5

    public static void main(String[] args) {

        String s1 = "abbcccddddeeeee";
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i < s1.length(); i++){

            if(map.containsKey(s1.charAt(i)))
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            else
                map.put(s1.charAt(i),1);

        }


        for(Map.Entry<Character,Integer> entry : map.entrySet()) {

            System.out.print(entry.getKey()+""+entry.getValue());
        }

    }
}
