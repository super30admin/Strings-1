# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
//Time Complexity = O(N)
//Space Complexity = O(26) == O(1)

class Solution {
    public String customSortString(String order, String str) {
        StringBuilder sb = new StringBuilder(); 
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1); 
        }
        
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                    while(count > 0){
                        sb.append(c);
                        count--; 
                     }
            }
            map.remove(c); 
        }
        
        for(char key: map.keySet()){
            int count = map.get(key); 
            
            while(count > 0){
                sb.append(key); 
                count--; 
            }
        }
        
        return sb.toString(); 
    }
}


## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

//Time Complexity = O(N)
//Space Complexity = O(26) = O(1)
//Sliding window approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0; 
        
        //String sb = ""; 
        
        int slow = 0; 
        int max = 0;
        
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); 
            
            if(!map.containsKey(c)){
                map.put(c, i + 1); 
            }else{
                slow = Math.max(slow, map.get(c)); 
                map.put(c, i + 1); 
            }
            
            // if(i - slow + 1 > max){
            //     sb = s.substring(slow, i + 1);    
            // }
   
            max = Math.max(max, i - slow + 1);
            
            //System.out.println(sb);
 
        }
        return max; 
    }
}