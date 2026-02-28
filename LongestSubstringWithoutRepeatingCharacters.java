// TC: O(n)
// SC: O(1)

// 1: We maintain a HashMap that stores the indexes of the letters we have encountered thus far during the iteration of the string
// 2: If a character already exists, we determine whether the character is a part of the current window. If yes, we increment the window to the letter after the last occurrence
// 3: After each letter, we update the max length after calculating the size of the current window
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                // character exists, move slow pointer
                slow = Math.max(slow, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}