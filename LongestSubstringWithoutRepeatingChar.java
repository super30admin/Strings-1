import java.util.*;

public class LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int slow = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                slow = Math.max(indexMap.get(c) + 1, slow);
            }
            indexMap.put(c, i);
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}

//TC: O(n), SC: O(1) - as will be having max 26 characters in the hashMap
