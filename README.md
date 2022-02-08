# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
class Solution {
    //Time Complexity : O(m+n) m = order.len n= source.len 
    //Space Complexity: O(1) - hashmap has only 26 keys 
    public String customSortString(String order, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i< str.length(); i++)
        {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c,0) +1);
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i< order.length(); i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                int cnt = map.get(c);
                for(int k=0; k < cnt; k++)
                {
                    result.append(c);
                }
                map.remove(c);
            }
        }
        
        for(char c : map.keySet())
        {
            int count = map.get(c);
            for(int k=0; k < count; k++)
            {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}


## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

class Solution {
    //Time Complexity: O(l) where l = string's length
    //Space Complexity: O(1) since hashmap can only have a maximum of 26 characters  
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        int startIndex =0;
        for(int i=0; i < s.length();i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                startIndex = Math.max(startIndex, map.get(c));
            }
            map.put(c,i+1);
            max = Math.max(max, i- startIndex +1);
        }
        return max;
    }