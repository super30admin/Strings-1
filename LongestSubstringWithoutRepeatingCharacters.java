import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        int max = 0;

        while(i<s.length() && j<s.length()) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j))+1);//try "abba"-> why we need to get the max and not map.get(s.charAt(j))+1
            }
            max = Math.max(max, j - i+1);
            map.put(s.charAt(j), j);
            j++;
        }

        return max;
    }
}
