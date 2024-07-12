// Time Complexity : O(n) where n is the length of string s
// Space Complexity : O(1) // Even though we are using a set, consider we have all lower case still we will still be storing only 26 char
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Was calculating value of max before incrementing right pointer

/*
Approach: User 2 pointers left and right starting from 0. In the set, check if the character does not exist, then add the character in set, increment right pointer and calculate max by checking Math.max(max, right - left). If the character is present in set then remove from the set and move the left pointer.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int left = 0;
        int right = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;

        while(right < n){

            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                right++;
                max = Math.max(max, right - left);
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }

        }

        return max;
    }
}