package longestSubstring;

import java.util.HashSet;

//tc: O(n)
//sc: O(1)

class Approach1 {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet();
        int maxLength = 0;
        int n = s.length();
        int slow = 0;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(set.contains(ch)) {
                // slide the slow poiner to escpe the repeat character

                while(s.charAt(slow) != ch) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            } else {
                set.add(ch);
            }

            maxLength = Math.max(maxLength, i- slow + 1 );

        }

        return maxLength;
    }
}