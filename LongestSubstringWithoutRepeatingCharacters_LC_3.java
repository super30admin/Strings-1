/*HashMap Solution
Time Complexity - O(N)
Space Complexity - O(1)

Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class LongestSubstringWithoutRepeatingCharacters_LC_3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for(int right = 0; right <s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left +1);
        }
        return max;
    }
}



/* HashSet Solution naive-
//TC- O(N), SC-O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int start = 0, end = 0, max = 0;
        while(end < s.length()) {
            if(!hs.contains(s.charAt(end))){
                hs.add(s.charAt(end));
                end++;
                max = Math.max(max, end - start);

            } else {
                char ch = s.charAt(start);
                hs.remove(ch);
                start++;

            }
        }
        return max;
    }
}


//HashSet Solution - better run time
//Time Complexity - O(N) space- O(1) 26 chars
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int start = 0, end = 0, max = 0;
        while(end < s.length()) {
            if(hs.contains(s.charAt(end))){
                while(s.charAt(start) != s.charAt(end)){
                    hs.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                char ch = s.charAt(end);
                hs.add(ch);
            }
            end++;
            max = Math.max(max, end - start);
        }
        return max;
    }
}
*/

