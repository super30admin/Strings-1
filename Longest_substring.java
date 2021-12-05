// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int result=0;
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                i++;
            }else{
                result=Math.max(result,set.size());
                char cp=s.charAt(i-set.size());
                set.remove(cp);
            }
        }
        
        return Math.max(set.size(),result);
    }
}