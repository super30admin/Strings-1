package Strings1;

import java.util.HashMap;

public class question94_LongestSubstringWithoutRepeatingCharacters {
    /* Created by palak on 7/12/2021 */

    /*
        Time Complexity: O(n)
        Space Complexity: O(1)
    */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int slow = 0;

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, i - slow + 1);
            map.put(c, i+1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
