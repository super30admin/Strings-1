import java.util.HashSet;
import java.util.Set;
/*
Time Complexity : O(s), length of the string
Space Complexity : O(1), keep unique chars, max possible ASCII characters
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :
Keep 2 pointers. Add new char from right pointer. Remove new character from left. Keep track of max length between left and
right pointer.
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while(right < s.length()){
            char curr = s.charAt(right);
            if(set.contains(curr)){
                while (set.contains(curr)){
                    // add duplicate char from left
                    set.remove(curr);
                    left++;
                }
            }
            // add new char from right
            set.add(s.charAt(right));
            right++;
            // since right has incremented already, no need to add plus 1 to the len
            maxLen = Math.max(maxLen, right-left);
        }

        return maxLen;
    }
}
