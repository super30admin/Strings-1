// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
import java.util.*;
class customSort {
    public String customSortString(String order, String s) {
        if(s == null || s.length() == 0 || order == null || order.length() == 0)
            return s;
        
        Map<Character, Integer> countMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        //update count in the map
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            
            if(countMap.containsKey(ch)){
                int count = countMap.get(ch);
                
                while(count > 0){
                    result.append(ch);
                    count--;
                }
                countMap.remove(ch);
            }
        }
        
        for(char key: countMap.keySet()){
            int count = countMap.get(key);
            while(count > 0){
                    result.append(key);
                    count--;
            }
            //concurrent modification exception: iterating through the map and updating at the same time
            //countMap.remove(key);    
        }
        
        return result.toString();
    }
}