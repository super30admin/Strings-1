// TC - O(n)
// SC - O(1) constant number of characters


/*
CUse a sliding window with two pointers where right expands the window and left shrinks it to maintain a substring with no repeating characters.
Store each character’s latest index in a HashMap so when a duplicate appears, left can jump to max(left, lastIndex + 1) to keep the window valid.
At every step, compute the window length as right - left + 1 and update the maximum length found so far.
*/

import java.util.HashMap;

class Problem2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(hmap.containsKey(ch)) {
                left = Math.max(left, hmap.get(ch) + 1);
            } 

            hmap.put(ch, right);
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}