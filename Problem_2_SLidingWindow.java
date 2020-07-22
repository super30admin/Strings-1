// Time complexity - O(2n)
// Space complexity - O(1)

// Sliding window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character,Integer> map  = new HashMap<>();
        int slow = 0;
        int fast = 0;
        int max = 0;
        while(fast  < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c,fast + 1);
            max = Math.max(max,fast-slow+1);
            fast++;
        }
        return max;
    }
}
