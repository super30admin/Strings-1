/*
Time Complexity: O(n) - We traverse the string once using a sliding window approach.
Space Complexity: O(min(n, 26)) - The HashMap stores at most 26 characters (if considering only lowercase English letters), otherwise O(n) for an arbitrary character set.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //base
        if(s == null || s.length() == 0) {
            return 0;
        }

        //logic
        int max = 0, start = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            max = Math.max(max, i-start+1);
            map.put(c, i+1);
        }
        return max;
    }
}