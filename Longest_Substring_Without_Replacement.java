/*
   Time Complexity - O(n) where n is the length of the string s.
   Space Complexity - O(n). 
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 1);
        int start = 0, maxLen = 1;

        for(int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
                start = Math.max(start, map.get(ch));
            map.put(ch, i + 1);
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }
}
