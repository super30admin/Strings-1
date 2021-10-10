package Strings1;
// Time Complexity : O(length of string)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(counter.containsKey(c)){
                for(int j=0; j<counter.get(c); j++){
                    sb.append(c);
                }
                counter.remove(c);
            }
        }
        for(char c : counter.keySet()){
            for(int j=0; j<counter.get(c); j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
