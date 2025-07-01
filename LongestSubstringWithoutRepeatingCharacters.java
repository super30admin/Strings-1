//time complexity-  O(n)
//space complexity- O(1)

import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
        static int lengthOfLongestSubstring(String s) {
            int len = s.length();
            if(len < 2) return len;

            int i = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            for(int j = 0; j < len; j++) {
                if(map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j))+1, i);
                }
                map.put(s.charAt(j), j);
                max = Math.max(max, j-i+1);
            }

            return max;
        }

    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println("The length of longest substring without repeating characters of string \"" + str + "\" is: " + lengthOfLongestSubstring(str));
    }

}
