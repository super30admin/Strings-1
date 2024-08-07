import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        HashMap<Character, Integer> mapofIndex = new HashMap<>();
        int maxl = Integer.MIN_VALUE;
        int slow = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (mapofIndex.containsKey(c)) {
                slow = Math.max(mapofIndex.get(c) + 1, slow);

            }
            mapofIndex.put(c, i);
            maxl = Math.max(maxl, (i - slow + 1));
        }

        return maxl;

    }

}
