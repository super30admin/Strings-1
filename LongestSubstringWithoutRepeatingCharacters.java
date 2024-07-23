// Time Complexity : O(n), n-length of string
// Space Complexity : O(min(m,n)), m - set/hashmap size
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Hashset + 2 pointers
/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            if(!set.contains(c)) {
                set.add(c);
                maxLength = Math.max(maxLength, right-left+1);
                right++;
            }else {
                char cLeft = s.charAt(left);
                set.remove(cLeft);
                left++;
            }
        }
        return maxLength;
    }
}*/

// HashMap + sliding window
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    int start = 0;
    Map<Character, Integer> hashmap = new HashMap<>();
    for(int i = 0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(hashmap.containsKey(c)) {
        start = Math.max(start, hashmap.get(c));
      }
      maxLength = Math.max(maxLength, i-start+1);
      hashmap.put(c, i+1);
    }
    return maxLength;
  }
}