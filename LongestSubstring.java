//TC : O(n) , n- length of string
//SC : O(1)


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null)
            return 0;
      //  System.out.println("String length"+s.length());
        
        int slow=0,fast=0,max = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(fast<s.length()){
            Character c = s.charAt(fast);
            //if fast pointer comes across a repeat character
            if(map.containsKey(c)){
                //move slow to the new place, if not behind
                slow = Math.max(slow,map.get(c));  
            }
            //store a new value for the character, store +1 for moving slow to the next nonrepeat character 
            map.put(c,fast+1);
            
            //Check max value
            max = Math.max(fast-slow+1,max);
            
            fast++;   
        }
      //  System.out
        return max;
    }
}