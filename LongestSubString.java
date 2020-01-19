//Time : O(n)
//Space : O(26) = constant
//Leetcode: Yes
// Any issue: No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //base case
        if(s==null || s.length()==0) return 0;
        //logic
        int max = 0;
        int slow=0, fast=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(fast<s.length()){
            char c=s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(map.get(c), slow);
            }
            map.put(c, fast+1); //fast acts as index
            max = Math.max(fast-slow+1, max);
            fast++;
        }
        
        return max;
    }
}
