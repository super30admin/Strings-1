// Time Complexity : O(n+m) where n is the length of the string s and m is the length of string order
// Space Complexity :O(1) since the HashMap will have a fixed number of keys = 26
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
import java.util.HashMap;

public class CustomSortString {
    private StringBuilder result;
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        result = new StringBuilder();

        for(int i =0; i<s.length(); i++){
            Character current = s.charAt(i);
            if(!map.containsKey(current)){
                map.put(current, 0);
            }
            map.put(current, map.get(current)+1);
        }

        for(int i=0; i<order.length();i++){
            if(map.containsKey(order.charAt(i))){
                int count = map.get(order.charAt(i));
                for(int j =0; j< count; j++){
                    result.append(order.charAt(i));
                }
                map.remove(order.charAt(i));
            }
        }

        for(Character c: map.keySet()){
            int count = map.get(c);
            for(int j =0; j< count; j++){
                result.append(c);
            }
        }
        return result.toString();
    }
}
