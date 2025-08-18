# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
//TC : O(n)
//SC :  O(1)


class Solution {
    public String customSortString(String order, String s) {
        if (s.length() == 0) {
            return "";
        }

        Map<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        // Place characters according to order
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (hm.containsKey(ch)) {
                int value = hm.get(ch);
                while (value > 0) {
                    sb.append(ch);
                    value--;
                }
                hm.remove(ch);
            }
        }

        // Add remaining characters
        for (char key : hm.keySet()) {
            int value = hm.get(key);
            while (value > 0) {
                sb.append(key);
                value--;
            }
        }

        return sb.toString();
    }
}


## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

//TC : O(n)
//SC : O(1)


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashSet<Character> hs = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            // If duplicate, shrink from left
            while (hs.contains(c)) {
                hs.remove(s.charAt(left));
                left++;
            }

            // Add current char and update window size
            hs.add(c);
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}