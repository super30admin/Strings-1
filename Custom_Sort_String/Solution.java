// Time Complexity : O(n + m) where n = length of s and m = length of order
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We will iterate over of s and make an entry of each character and its count in hashmap
 * then we iterate over order and for each char we take its count from hashmap and 
 * add that char count many times to stringbuilder. After processing of that char is done, we will delete its entry from hashmap
 * finally we check if hashmap is empty or not. If not then, we add remaining char to stringbuilder their count no of times
*/

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                map.remove(ch);
                
                for(int j = 0; j < count;j++){
                    sb.append(ch);
                }
            }
        }
        
        if(map.size() > 0){
             for(Character ch: map.keySet()){
                int count = map.get(ch);
                for(int j = 0; j < count;j++){
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
    }
}