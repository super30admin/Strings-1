// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Store frequency of each element in string s in the map. 
 * Check if the element in order string is present in s. Find the frequency and add same character n times until the frequency is exhausted. 
 * Once done, remove the element from map. 
 * Append all the other characters in the map to the string and return it. 
 */


public class Problem2 {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            Character odCh = order.charAt(i);
            if(map.containsKey(odCh)){
                 int cnt = map.get(odCh);
                 for(int k = 0; k < cnt; k++){
                     sb.append(odCh);
                 }
                 map.remove(odCh);
            }
        }
        for(Character ch: map.keySet()){
                 int cnt = map.get(ch);
                 for(int k = 0; k < cnt; k++){
                     sb.append(ch);
             }
        }
        return sb.toString();
     }
 }
