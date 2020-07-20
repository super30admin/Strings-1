// Time Complexity - O(N) N = len of string
// Space Complexity - O(1) // Hashmap size for storing max 26 chars with their indexes

// Main idea is to have a sliding window by maintaining two pointers - slow and fast pointers.
// The purpose of fast is to expand the substring by adding elements into the HashMap with the recent idx where the char is present
// and the purpose of slow is to shrink the substring whenever fast pointer is already present in HashMap.
// This shrinking happens until the fast pointer element exceeds the string length.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int slow = 0, fast = 0, max = 0;
        while(fast < s.length()) {
            char c = s.charAt(fast);
            if(map.containsKey(c)) {
                slow = Math.max(slow,map.get(c));
            }
            map.put(c,fast+1);
            max = Math.max(max,fast-slow+1);
            fast++;
        }
        return max;
    }
}