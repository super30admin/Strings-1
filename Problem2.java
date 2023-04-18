
//Time: O(n)
//Space: O(1)

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int slow = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if( map.containsKey(ch)) {
                slow = Math.max(slow, map.get(ch)+1);
            }
            map.put(ch, i);
            max = Math.max(max, i-slow+1);
        }
        return max;
    }
}