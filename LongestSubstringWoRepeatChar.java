
// Time Complexity : O(n) n is the number of chars in input string
// Space Complexity :O(n) n is the number of chars in input string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
      
      if(s== null || s.length()==0)
      {
        return 0;
      }
      //hashmap to store the character and its index
      HashMap<Character,Integer> map = new HashMap<>();
      //using two pointer l and r to maintain the window
      int l = 0;
      int r = 0;
      int max = Integer.MIN_VALUE;
      
      for(int i=0;i<s.length();i++)
      {
        char c = s.charAt(i);
        //move the l pointer to correct the window of the substring not contain repeating chars
        if(map.containsKey(c))
        {
          l = Math.max(l,map.get(c)); 
        }
        //put the char to hashmap with its index and increase the window with the right pointer and update the max to the  current window size if greater
          map.put(c,r+1);
          max = Math.max(max , r-l +1);
          r++;
      }
        return max;
    }
}