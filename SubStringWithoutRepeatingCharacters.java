// Time Complexity : O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
            
        Map<Character,Integer> hashmap = new HashMap<>();
        int S=0, E=0;
        int max = Integer.MIN_VALUE;
        
        while(E<s.length()){
            char ch = s.charAt(E);
            if(hashmap.containsKey(ch)){
              S=Math.max(S, hashmap.get(ch));
            }
            hashmap.put(ch, E+1);
            max= Math.max(max,E-S+1);
            E=E+1;
        }
        return max;
    }
    
}