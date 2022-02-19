// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a HashMap to store character and it's occurence. Create a slow
// pointer i and fast pointer j and the distance between i and j represents 
// the length of the sliding window with unique characters. Create a max 
// variable to keep track of the longest sliding window. Iterate over the 
// string using fast pointer and initialize slow pointer with 0 if the character
// is present in HashMap update the slow pointer to the maximum value of 
// current slow pointer value and value correseponding to the character key in
// HashMap + 1. If not present just add character and its index to the map.
// Finally return the max value. 

class Solution {
    HashMap<Character,Integer> m = new HashMap<>();
    int i = 0;
    int max = 0;
    public int lengthOfLongestSubstring(String s) {
      if(s.length() == 1){
          return 1;
      }
      for(int j=0;j<s.length();j++){
          if(m.containsKey(s.charAt(j))){
              i = Math.max(m.get(s.charAt(j))+1,i);
          }
          m.put(s.charAt(j),j);
          if(max<j-i+1){
             max = j-i+1;
          }
      } 
      return max;
    }
}