import java.util.HashMap;

// Time Complexity : Add : O(m+n) m-length of string ; n -length of order
// Space Complexity : O(1) - HashMap contains only 26 letters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CustomSortString {
    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        customSortString(order, s);
    }

    public static String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                for(int k=0; k<count; k++){
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        for(char ch: map.keySet()){
            int count = map.get(ch);
            for(int i=0; i<count; i++){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

