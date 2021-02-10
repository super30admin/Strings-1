import java.util.HashMap;

// Time Complexity :O(S+T)
// Space Complexity :O(T)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class CustomSortStringCode {

    class Solution {
        public String customSortString(String S, String T) {
            StringBuilder sb = new StringBuilder();
            if(T == null || T.length()==0) return sb.toString();

            //create hashmap to store count of chars in T
            HashMap<Character, Integer> map = new HashMap<>();

            //loop over T and add char to hash map
            for (int i = 0; i < T.length(); i++) {
                char c= T.charAt(i);
                map.put(c, map.getOrDefault(c,0)+1);
            }

            //iterate over s and get values from hashmap and place in S order 
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if(map.containsKey(c)){
                    int count = map.get(c);
                    while(count>0){
                        sb.append(c);
                        count--;
                    }
                    map.remove(c);//remove char after appending it to string builder
                }
            }
            
            //iterate over hashmap and append remaining char to stringbuilder
            for(char c: map.keySet()){
                int count = map.get(c);
                while(count>0){
                    sb.append(c);
                    count--;
                }
            }
            return sb.toString();
        }
    }
}
