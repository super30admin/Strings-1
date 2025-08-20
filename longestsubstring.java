//Time Complexity: O(n) — each character is processed once as the window slides.
//Space Complexity: O(1) — fixed size array of 256 for ASCII characters.

//Maintain a sliding window and an array map[256] storing last seen index of each char (init -1).
//For each char c at i, if it was seen, move slow = max(slow, map[c] + 1) to skip its previous occurrence.
//Update map[c] = i and max = max(max, i - slow + 1); return max.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int n = s.length();
        int max = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map[c] != -1) {
                slow = Math.max(slow, map[c] + 1);
            }
            map[c] = i;
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}
