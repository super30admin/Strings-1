// Time Complexity : O(n); where n = length of the source string 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        // iterate through the source string and make a frequency map
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // iterate through the order string and remove the keys from the frequency map accordingly
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int j = 0; j < cnt; j++){
                    result.append(c);
                }
                map.remove(c);
            }
        }
        
        // iterate through the remaining keys (source string) and append it to the result
        for(char c : map.keySet()){
            int count = map.get(c);
            for(int k = 0; k < count; k++){
                result.append(c);
            }
        }
        return result.toString();
    }
}