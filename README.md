# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
## Time Complexity and space complexity:O(M+N) 
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String customSortString(String order, String s) {
        // Frequency map to store the count of each character in s
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

      
        StringBuilder sb = new StringBuilder();

        
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
               
                map.remove(c);
            }
        }

      
        for (char c : map.keySet()) {
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }

       
        return sb.toString();
    }
}


## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)
## Time :O(n) SPace:O(k)
class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n=s.length();

       HashMap<Character,Integer> map=new HashMap<>();
       int max=0;
       int slow=0;
       for(int i=0;i<s.length();i++)
       {
        char c=s.charAt(i);
         if (map.containsKey(c) && map.get(c) >= slow)
        {
            slow=map.get(c)+1;
            

        }
        map.put(c,i);
        max=Math.max(max,i-slow+1);
     
       }
          return max;
    }
}