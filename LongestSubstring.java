import java.util.HashMap;

public class LongestSubstring {
    //time - o(n)
    // space - constant as we are usng fixed number of chars
    // start at zero. i=0 and hashmap empty
    // check hashmap if the char exists, if not add the char and the next
    //index indicating where the start should be if the char appears again.
    // calculate max by formula i-start +1.
    // every step keep the math.max(mx, new i-start +1)
    //if you encounter the character again update the map value to the next index
    // to avoid jumping the start back to the older index, always keep the start at
    // the max of(start, mp.get(c))
    // at the end return max.
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            max = Math.max(max, i - start + 1);
            map.put(c, i + 1);
        }
        return max;
    }
}
