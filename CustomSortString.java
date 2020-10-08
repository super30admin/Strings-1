// Time Complexity : O(n) to traverse the characters in both the strings
// Space Complexity : O(n) number of characters in string T
// and in worst case it can reach the total number of intervals.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap();
        StringBuilder permuteStr = new StringBuilder();
        
        for(char ch: T.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        
        for(char ch: S.toCharArray()){
            int count = map.getOrDefault(ch, 0);
            
            while(count-- > 0){
                permuteStr.append(ch);
            }
            
            map.remove(ch);
        }
        
        for(char ch: map.keySet()){
            int count = map.get(ch);
            
            while(count-- > 0){
                permuteStr.append(ch);
            }
        }
        return permuteStr.toString();
    }
}
