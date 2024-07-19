import java.util.HashMap;
import java.util.Map;

/***
 Approach - Using 2 pointers and hashmap
 TC - O(n)
 SC - O(n)
 */
class LongestSubstrWoRepeatChars {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int start =0;

        for(int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(map.containsKey(ch)) {
                //move start pointer to max of start and stored index in map
                start = Math.max(start, map.get(ch));
            }

            map.put(ch, i+1);
            max = Math.max(max, i - start + 1);
        }

        return max;

    }
}