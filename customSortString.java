/*
Problem: https://leetcode.com/problems/custom-sort-string/
TC: O(m + n)
SC: O(1) -> 26 characters. But string builder takes O(s.length()) space
*/
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        
        for (Character c : s.toCharArray()) {
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder result = new StringBuilder();
        
        for (Character c : order.toCharArray()) {
            if (charFreqMap.containsKey(c)) {
                int times = charFreqMap.get(c);
                
                while (times-- > 0) {
                    result.append(c);
                }
                charFreqMap.remove(c);
            }
        }
        
        for (Character c : charFreqMap.keySet()) {
            int times = charFreqMap.get(c);
                
            while (times-- > 0) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}