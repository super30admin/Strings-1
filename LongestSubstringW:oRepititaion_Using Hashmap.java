// Time Complexity :O(n) n= length of String
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() ==0)
            return 0;
        int p1 =0; 
        int max = 0;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
     
        for(int p2 = 0; p2<n;p2++)
        {
            char c = s.charAt(p2);
            if(map.containsKey(c))
            {
                int index = map.get(c);
                int len = p2-p1;
                p1 = Math.max(index,p1);
               
            }
             max = Math.max(max,p2-p1+1); 
            
            map.put(c,p2+1);
        }
        
        return max;
    }
}


----------------- OR Same approach with diff Coding style-------------------

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() ==0)
            return 0;
        int p1 =0; int p2 = 0;
        int max = Integer.MIN_VALUE;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        while(p1<n && p2<n)
        {
            char c = s.charAt(p2);
            if(map.containsKey(c))
            {
               int ind = map.get(c);
              
                int count = p2-p1;
                max = Math.max(max,count);
                map.put(c,p2+1);
                p1 = Math.max(ind,p1);
                p2++;
              
              
                // map.put(c,p2);
            }
            else
            {
                map.put(c,p2+1);
                p2++;
                
            }
            
            if(p2 == n)
            {
                int count = p2-p1;
                max = Math.max(max,count);
                
              return max;
            }
        }
        
        return max;
    }
}