/**
Time Complexity: O(n), Space Complexity: O(min(n, m)). Utilizes sliding window with HashSet to find the length of the longest substring without repeating characters.

 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l=0;
        int maxLen=0;
        for(int r=0;r<s.length();r++){
            if(!set.contains(s.charAt(r))) 
            { 
                set.add(s.charAt(r));
                maxLen = Math.max(maxLen,r-l+1);
            }
            else{
                while(s.charAt(l) != s.charAt(r)){
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
                set.add(s.charAt(r));
            }
        }
        return maxLen;
        
    }
}
