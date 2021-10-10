// Time Complexity : O(N) where N is length of String s
// Space Complexity : O(1) HashMap will have max 26 characters
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Three line explanation of solution in plain english: Iterate over the string and create a map of character and index+1.
// Now if a repeated character is found move the slow pointer to skip that element.
// The slow pointer will only move ahead. Compute the max by subtracting the current index and the slow pointer and return the max.


class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int slow = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for(int  i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                slow = Math.max(slow, hm.get(c));
                max = Math.max(max, (i-slow));
            }
            max = Math.max(max, (i-slow)+1);
            hm.put(c, i+1);
        }
        return max;
    }
}