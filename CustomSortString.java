// Time Complexity : O(m+n) where m = length of s, n = length of order
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//791. Custom Sort String (Medium) - https://leetcode.com/problems/custom-sort-string/
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) { // O(m) where m = length of s
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < order.length(); i++) { // O(n) where n = length of order
            char ch = order.charAt(i);
            
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                
                while (count > 0) { // O(k) where k = number of occurences of character in s
                    sb.append(ch);
                    count--;
                }
                
                map.remove(ch);
            }
        }
        
        for (Character ch : map.keySet()) { // O(l) where l = reaining characters in hashmap or characters not common in order & s
            int count = map.get(ch);
            
            while (count > 0) {
                sb.append(ch);
                count--;
            }
        }
        
        return sb.toString();
    }
}