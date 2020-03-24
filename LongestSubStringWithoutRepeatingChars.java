//Time Complexity: O(2n) -> length of the string :: coz we are parsing the string twice with start and end pointers
//Space: O(n) or can be constant if there are only 26 chars

class Solution {
      public int lengthOfLongestSubstring(String s) {
       
          if(s == null || s.length()==0)
              return 0;
          
          if(s.length()==1)
              return 1;
          
          //to have unique elements inside the window
          Set<Character> hs = new HashSet<>();
          int length =0;
          int start =0; int end=0;
          while(end < s.length())
          {
              if(!hs.contains(s.charAt(end)))
              {
                  hs.add(s.charAt(end));
                  end++;
                  length = Math.max(length, (end-start));
              }else
              {
                  hs.remove(s.charAt(start));
                  start++;
              }
          }
         
        return length;
    }
}
