// Time - O(N)
// Space - O(N)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int slow = 0;
        int max = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                slow = Math.max(slow, map.get(ch));
            }
            map.put(ch, i + 1);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}
