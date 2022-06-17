// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes


class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> indexMap = new HashMap<>();
        int maxLength = 0;
        int startW = 0;
        int endW = 0;
        while (endW < s.length()) {
            char c = s.charAt(endW);
            if (indexMap.containsKey(c)) {
                startW = Math.max(startW, indexMap.get(c) + 1);
            }
            indexMap.put(c, endW);
            maxLength = Math.max(maxLength, endW - startW + 1);
            endW++;
        }
        return maxLength;
    }
}