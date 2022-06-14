//Time: O(N) | Space: O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int slow = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int fast=0;fast<s.length();fast++) {
            char curr = s.charAt(fast);
            if(map.containsKey(curr)) {
                // repeats are there,
                // we take max of the previous first occurence of redundant character position +1
                // or current slow pointer if current slow pointer is past the first occurence pos of duplicate
                slow = Math.max(slow, map.get(curr));
            }
            map.put(curr, fast+1);
            // taking max of substring
            max = Math.max(max, fast-slow+1);
        }
        return max;
    }
}