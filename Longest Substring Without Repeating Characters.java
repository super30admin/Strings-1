// Time Complexity : O(N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes

class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0)
      return 0;
    HashMap<Character, Integer> map = new HashMap<>();
    int slow = 0, max = 0;

    for (int fast = 0; fast < s.length(); fast++) {
      char c = s.charAt(fast);
      if (map.containsKey(c)) {
        slow = Math.max(slow, map.get(c));
      }
      if (fast - slow + 1 > max) {
        max = fast - slow + 1;

      }
      map.put(c, fast + 1);
    }
    return max;

  }
}