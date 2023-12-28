// Time Complexity : O(2n) -> O(n)
// Space Complexity : O(26) -> O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Sliding window, Two Pointer. HashSet
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;

        for(int right = 0; right<s.length(); right++) {

            char c = s.charAt(right);

            if(set.contains(c)) {
                while(c != s.charAt(left)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            else {
                set.add(c);
                max = Math.max(max, right-left+1);
            }
        }

        return max;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(26) -> O(1)
/**
 * Sliding Window, HashMap
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;

        for(int right = 0; right<s.length(); right++) {

            char c = s.charAt(right);
            if(map.containsKey(c) && left<=map.get(c)) {
                left = Math.max(left, map.get(c)+1);
                map.put(c, right);
            }
            else {

                map.put(c, right);
                max = Math.max(max, right-left+1);
            }
        }

        return max;
    }
}