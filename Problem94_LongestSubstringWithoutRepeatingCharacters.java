// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        String str = s;
        if(str == null || str.length() == 0)
            return 0;
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int startIdx = 0;
        int currentLongest[] = {0, 1};
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(lastSeen.containsKey(c))
                startIdx = Math.max(startIdx, lastSeen.get(c) + 1);
            if(currentLongest[1] - currentLongest[0] < i + 1 - startIdx)
                currentLongest = new int[] {startIdx, i + 1};
            lastSeen.put(c, i);
        }
        return currentLongest[1] - currentLongest[0];
    }
}