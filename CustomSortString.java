// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public String customSortString(String order, String s) {
    // Edge case:
    if(s == null || s.length() == 0) return s;
    Map<Character, Integer> sMap = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    for(char c: s.toCharArray()) {
      sMap.put(c, sMap.getOrDefault(c,0)+1);
    }

    // Iterate through order and check if it exists in the map.
    for(char c: order.toCharArray()) {
      while(sMap.containsKey(c) && sMap.get(c) > 0) {
        sb.append(c);
        sMap.put(c, sMap.get(c)-1);
      }
      sMap.remove(c,0);
    }
    // Append all the left over keys
    for(char c: sMap.keySet()) {
      while(sMap.get(c) > 0) {
        sb.append(c);
        sMap.put(c, sMap.get(c)-1);
      }
    }
    return sb.toString();
  }
}