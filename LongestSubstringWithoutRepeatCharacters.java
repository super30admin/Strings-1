

//Time Complexity : O(n) i.e s.length
//Space Complexity : O(n)
//Did it run on leetcode : yes
//Did you face any problems  : no

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0 || s=="")
            return 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        int maxLength = Integer.MIN_VALUE;
        int slow = 0 ;
        int fast  = 0;
        while(fast  < s.length()){
            char c  = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow , map.get(c));
                //map.put(c,fast+1);               
            }   
           map.put(c,fast+1); 
           maxLength = Math.max(maxLength,fast-slow+1);
            fast++;
            
        }
        return maxLength;
        
    }
}