# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

class Solution {
    // TC O(n+m) SC O(1)
    public String customSortString(String order, String s) {
        if(order == null || order.length()==0) return s;
        
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) +1);
            
        }
       for(int i =0; i< order.length(); i++){
           char c = order.charAt(i);
           
           if(map.containsKey(c)){
               int cnt = map.get(c);
               while(cnt>0){
                   sb.append(c);
                   cnt--;
               }
           }
           map.remove(c);
       } 
        for(char c: map.keySet()){
            
            int cnt = map.get(c);
            while(cnt>0){
                sb.append(c);
                cnt--;
            }
        }
        return sb.toString();
    }
}


## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

class Solution {
    //TC O(n) SC O(1)
    public int lengthOfLongestSubstring(String s) {
        //base case
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int slow = 0, fast =0;
        int max = 0;
        for(fast  = 0;  fast <s.length(); fast++){
            char c = s.charAt(fast);
             if(map.containsKey(c)){
              
            slow = Math.max(slow, map.get(c));
            }
                  max = Math.max(max, fast-slow+1);
                
                map.put(c, fast+1);   
                 
            

        }
        return max;
    }
}
