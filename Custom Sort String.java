// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  public String customSortString(String S, String T) {
    if (S == null || S.length() == 0)
      return T;

    StringBuilder sb = new StringBuilder();
    HashMap<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < T.length(); i++) {
      char c = T.charAt(i);
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);

      if (freq.containsKey(c)) {
        int times = freq.get(c);
        for (int j = 0; j < times; j++) {
          sb.append(c);
        }
        freq.remove(c);
      }

    }

    for (char c : freq.keySet()) {
      int times = freq.get(c);
      for (int j = 0; j < times; j++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}