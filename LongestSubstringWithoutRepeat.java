// Time Complexity : O(n) where n is the lengths of string s.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : Place left pointer at start and move the right pointer until a repeat char is encountered by checking with the hashset.
// Move the left pointer to the first occurence + 1 position of the repeated character and capture the max length at each time.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxlen = 0;
        for(int right = 0; right< s.length();right++){
            char ch = s.charAt(right);
            if(set.contains(ch)){ //first repeat char is found
                while (s.charAt(left) != ch) { //move left until first occurence of the repeated char
                    set.remove(s.charAt(left));
                    left++;
                }
                left++; //place the left at occurence + 1
            }
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen, right-left+1); //compare length at each point
        }

        return maxlen;
    }
}
