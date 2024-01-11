// Time Complexity : O(s) where s is the length of string 's' 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public int lengthOfLongestSubstring(String s) {

    Set<Character> set = new HashSet<>();
        int max=0; 
        int start=0,end=0;

        while(end<s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                max = Math.max((end-start+1),max);
                end++;
            }
            else{
                // we have already found a repeating character so , we need to take the window }
                while(set.contains(s.charAt(end))){
                // no we need to move the start one step and remove the oputgoing character
                set.remove(s.charAt(start));
                ++start;
                }

            }
            
        }
        
       return max;
        
    }
}