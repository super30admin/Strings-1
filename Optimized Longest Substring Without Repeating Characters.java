Time: O(n)
Space: O(1)
Leetcode: https://leetcode.com/submissions/detail/627874189/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        
        int slow = 0; int f = 0;
        
        while(f < s.length()) {
            
            Character c = s.charAt(f);
            
            if(map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, f + 1);
            max = Math.max(max, f-slow+1);
             f++;
        }
        return max;
    }
}