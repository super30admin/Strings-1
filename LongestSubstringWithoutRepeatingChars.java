import java.util.HashMap;

// Time Complexity : Add : O(n) n-length of string
// Space Complexity : O(1) - HashMap contains only 26 letters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, max = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch));
            }

            map.put(ch, i+1);
            end++;

            max = Math.max(max, end-start);
        }

        return max;
    }
}

