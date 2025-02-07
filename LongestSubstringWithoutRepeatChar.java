/* 
Sliding Window Technique: 
Idea is to use start and end that is current window of focus. 
The end pointer would be putting characters into the set, making sure that 
duplicates are removed before we put it. The start pointer would be removing 
characters and incrementing until charAt[end] can be inserted in the
set. Track the global maxima on the fly.

TC: O(N)
SC: O(N)
*/

class Solution {

  public int lengthOfLongestSubstring(String s) {
    int start = 0, end = 0;

    Set<Character> set = new HashSet<>();

    int maxLen = 0;

    while (start < s.length() && end < s.length()) {
      Character ch = s.charAt(end);

      // remove char from set, until s[end] can be inserted.

      while (set.contains(ch)) {
        set.remove(s.charAt(start++));
      }

      // insert s[end]

      set.add(ch);

      maxLen = Math.max(maxLen, set.size());

      end++;
    }

    return maxLen;
  }
}
