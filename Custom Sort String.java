// Time Complexity : O(n) (length of T)
// Space Complexity : O(1) (26 chars)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public String customSortString(String S, String T) {
        //check for empty string case
        if(S.length() == 0 || T.length() == 0) return " ";
        //stringbuilder to append answer
        StringBuilder result = new StringBuilder();
        //Create a hashmap
        //add all chars of string t to the map, with no. of occurance
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1); 
        }
        
        //for each occurance of char in S get the count of char from map
        //(ie. occurance in string T)
        //get the count and append to result
        //then remove from map
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int count = 0;
            if(map.containsKey(c)) {
                count = map.get(c);
            }
            while(count > 0) {
                result.append(c);
                count--;
            }
            map.remove(c);            
        }
        
        //for all other chars of T not present in S
        //get map entry
        //get the count of char and append to result
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char c = entry.getKey();
            int count = entry.getValue();
            while(count > 0) {
                result.append(c);
                count--;
            }          
        }
        //return result as string
        return result.toString();
    }
}


