import java.util.HashMap;

//TC: O(n)
//SC: O(1)
//3. Longest Substring Without Repeating Characters

class Solution {
    public int longestSubstringWithoutReps(String s) {
        if (s == null) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c)); //If c is in the map we need to update the start first
            }
            max = Math.max(max, i - start + 1);
            map.put(c, i + 1); // Update the map whether the character is present or not
        }
        return max;
    }
}