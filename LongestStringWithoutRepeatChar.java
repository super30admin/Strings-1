public class LongestStringWithoutRepeatChar {
   /**
    Time Complexity: O(n)
    Space Complexity: O(1)

    Were you able to solve this on leetcode? Yes
    */
    public int lengthOfLongestSubstring(String s) {
      int slow = 0;
      int max = 0;
      
      Map<Character, Integer> map = new HashMap<>();
      for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          
          if(map.containsKey(c)){
              // Update the slow pointer location only if it is after the current location of slow.
              slow = Math.max(slow, map.get(c)+1);
          }
          
          max = Math.max(max, i - slow + 1);
          map.put(c, i);
          
      }
      
      return max;
      
  }
  
    /***
     *  Appraoch 2 Using a HashSet
     * 
     * Time Complexity: O(2n)
     * Space Complexity: O(1)
     * 
     * Were you able to solve this on leetcode? Yes
     * */ 
  
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
      
        Set<Character> set = new HashSet<>();
      
        int maxLen = 0;
      
        while(fast < s.length()){
            char c = s.charAt(fast);
          
          
            while(set.contains(c)){
                char charAtSlow = s.charAt(slow);
                set.remove(charAtSlow);
                slow++;
            }
          
            set.add(c);
            maxLen = Math.max(maxLen, fast - slow + 1);
          
            fast++;
        }
        return maxLen;
    }
}
