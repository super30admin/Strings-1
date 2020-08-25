// Time Complexity : O(n) where n is the number of elements in the string.
// Space Complexity : O(1) hashmap can have atmost 26 charcter keys.

Approach : Sliding Window

class Solution {
    public int lengthOfLongestSubstring(String s) {
         if(s==null ||s.length()==0) return 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        int max = 0; 
        int slow = 0; 
        int fast = 0;     
        while(fast < s.length()){
           if(map.containsKey(s.charAt(fast))){
               slow = Math.max(slow,map.get(s.charAt(fast)));
           }
            map.put(s.charAt(fast),fast+1); 
            max = Math.max(fast-slow+1,max);           
            fast++;
           }
            return max;
    }
}