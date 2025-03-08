## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

 

Example 1:

Input: order = "cba", s = "abcd"

Output: "cbad"

Explanation:  "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".

Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

Approach:
In this we will put all the s String's' all the characters with their frequency as value into the hashmap and then we will iterate through the order to find out the order in chich characters ara and also we will maintain a stringbuilder and append all strings
Time Complexity : O(m+n)
Space Complexity : As we are storingh only 26 characters so it will be constant = O(1)

class Solution {
    public String customSortString(String order, String s) {
        //base case check
        if(order==null || order.length()==0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<order.length();i++){
            char ch= order.charAt(i);
            int times = map.getOrDefault(ch,0);
            for(int j=0;j<times;j++){
                sb.append(ch);
            }
            map.remove(ch);
        }
        for(var entry:map.keySet()){
           int times= map.get(entry);
           char ch = entry;
            for(int i=0;i<times;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
}

//Some code modifications
class Solution {
    public String customSortString(String order, String s) {
        if(order==null || order.length()==0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<order.length();i++){
            char ch= order.charAt(i);
            int times = map.getOrDefault(ch,0);
            for(int j=0;j<times;j++){
                sb.append(ch);
            }
            map.remove(ch);
        }
        for(var entry:map.entrySet()){
           int times= entry.getValue();
           char ch = entry.getKey();
            for(int i=0;i<times;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
}