## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

// Time Complexity - 0(n + m) 
// Space Complexity - 0(n)

class Solution {
    public String customSortString(String order, String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int times = map.get(c);
                for (int j = 0; j < times; j++) {
                    result.append(c);
                }
                map.remove(c);
            }
        }
        for (char key : map.keySet()) {
            int times = map.get(key);
            for (int j = 0; j < times; j++) {
                result.append(key);
            }
        }
        return result.toString();
    }
}

## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

// Time Complexity - 0(n) because while loop in the code runs until the 'right' pointer reaches the end of the string, which takes O(n) time.
// Space Complexity - 0(m) as HashMap can store up to m key-value pairs, where m is the size of the character set. 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }
            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }   
        return maxLength;
    }
}
