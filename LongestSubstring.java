//Problem : 94 - Longest Substring Without Repeating Characters
//TC: O(N), N is the length of the given string
//SC: O(N)

/*
  1) Bruteforce: Iterate over each character amd make pair with remaining characters and check whether all characters in that pair are unique or not using set. If they are unique, just record the max length otherwise ignore it.
  
  TC: O(n^3) because first making pairs and then for each pair again traversing the whole string for validating unique characters
  SC: O(k), because of unique characters in the set
  
  2) Optimal : TC: O(N) |SC:O(N);
               Using two pointers and HashMap
               1) Initialise two pointers which are slow and fast pointer. Iterate over the string with the fast pointer. Add the character and its index in the the hash map, if they are not in the hashmap. 
               If they are in the hashmap just check the index of that character. If that character index is equal or greater than the slow pointer index, just calculate the length of that window and increment the slow pointer with 1, as well as remove that character from the map. 
               If slow pointer is lesser or equal to the idx, just make sure length is calculated between fast pointer -1 and the slow pointer, currently fast pointer will be pointing towards the repeated character and we cannot include the repeated character thats why.

               Otherwise if current found character idx is lesser than the slow pointer index,consider current index for calculating the length 

  

*/

import java.util.*;
class Solution94 {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()==0) return 0;
        
        
        //TC: O(N) |SC:O(N);
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int winStart =0;
        int len =0;
        for(int winEnd=0;winEnd<s.length();winEnd++){
            char ch = s.charAt(winEnd);
            
            if(map.containsKey(ch)){
                
                int idx = map.get(ch);
                if(idx>=winStart){
                 len = winEnd-winStart;
                 winStart = idx+1;    
                 map.remove(ch,idx); 
                }else{
                    len = winEnd-winStart+1;
                }
            }else{
                len = winEnd-winStart+1;
            }
            map.put(ch,winEnd);
            maxLen = Math.max(maxLen,len);
        }
        
        return maxLen==Integer.MIN_VALUE ? 1:maxLen;
        
        
        
        //Bruteforce
        //TC:O(n^3) || SC:O(k)-because set will contain unique characters
        /*for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(isValid(s,i,j)){
                    maxLen = Math.max(maxLen,j-i+1);
                }else{
                    break;
                }
        
            }
        }
        
        return maxLen==Integer.MIN_VALUE ? 1 : maxLen;*/
        
        
    }
    
    /*private boolean isValid(String s, int start,int end){
        Set<Character> seen = new HashSet<>();
        while(start<=end){
            char ch = s.charAt(start);
             if(seen.contains(ch)) return false;
            
             seen.add(ch);   
             start++;
            
        }
        return true;
    }*/
}

