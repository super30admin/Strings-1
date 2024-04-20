// Time Complexity : O(m+n)= O(n) where 'n' is the length of the string.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow)!=c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }else{
                set.add(c);
            }
            max = Math.max(max,i-slow+1);
        }
        return max;
    }
}
