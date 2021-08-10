// Time Complexity : O(n), [O(n+k), n = length of string s (200), k = length of string order (26)]
// Space Complexity : O(1), [O(k), k = lowercase english alphabets which is 26]
// Did this code successfully run on Leetcode : Yes

class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0 || s == null || s.length() == 0)
            return s;
        
        Map<Character, Integer> countMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        //update count in the hashmap 
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
        }
        
        //placing characters in order in the stringbuilder
         for(int i=0; i<order.length(); i++) {
             char ch = order.charAt(i);
             if(countMap.containsKey(ch)) {
                 int count = countMap.get(ch);
                 while(count > 0) {
                     result.append(ch);
                     count--;
                 }  
                 countMap.remove(ch);
             }
         }
        //placing the remaining characters in the stringbuilder
        for(char key : countMap.keySet()) {
            int count = countMap.get(key);
            while(count > 0) {
                result.append(key);
                count--;
            }  
        }
        return result.toString();
    }
}