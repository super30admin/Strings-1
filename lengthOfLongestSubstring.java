// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        Map<Character,Integer> map = new HashMap();
        
        int max=0, si=0, e=0;
        
        for(Character c : s.toCharArray()) {
            
            if(!map.containsKey(c) || map.get(c)<si) {
                
                map.put(c, e);
                max = Math.max(max,e-si+1);
            } 
            else {
                
                si = map.get(c)+1;
                
            }
            map.put(c, e);
            e++;

        }
        
        return max;
        
    }
}
