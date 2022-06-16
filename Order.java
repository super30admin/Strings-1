/*
m: length of order
n: length of input
Time Comp: O(n)+O(m*(Highest count of char)) ~> O(n)+O(m)
Space: O(1) : Map can store at the max 26 records for lower case Eng alphabets
*/
import java.util.HashMap;
import java.util.Map;

public class Order{
    public static void main(String[] args) {
       System.out.println(customSortString("cba","aiuswfdakzxbcvaks8ccccbbasfdasdbbbbaaawebbbaaaq"));
    }
    private static Map<Character, Integer> map;
    public static String customSortString(String order, String s) {
        map = new HashMap<>();
        for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        StringBuilder sb = new StringBuilder();
        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count-- > 0) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char c: map.keySet()){
            int count = map.get(c);
            while(count-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}