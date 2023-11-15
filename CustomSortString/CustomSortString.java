/* Time Complexity : O(m + n) 
*   n - length of source string - s 
*   m - length of order string - max len 26 */
/* Space Complexity : O(26) ~ O(1) 
*   size of the hashmap */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Hashmap solution

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //freq map of source string
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        //Iterating over the order str and generating a result string using freq map
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int freq = map.get(c);
                for(int j = 0; j < freq; j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        //append remaining chars present in the freq map - which were not there in the order str
        for(char c: map.keySet()){
            int freq = map.get(c);
            for(int i = 0; i < freq; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}