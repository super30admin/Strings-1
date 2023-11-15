/* Time Complexity : O(n) 
*   n - length of source string - s */
/* Space Complexity : O(26) ~ O(1) 
*   size of the hashset */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//HashSet solution

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int sp = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                //till the earlier occurence of c, remove chars from set incrementing the slow pointer
                while(s.charAt(sp) != c){
                    set.remove(s.charAt(sp));
                    sp++;
                }
                set.remove(s.charAt(sp));
                sp++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, i - sp + 1);
        }
        return maxLen;
    }
}