//Time complexity: O(N)
//Space complexity: O(min(M, N))
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, slow = 0;
        for(int i = 0 ; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                slow = Math.max(slow, map.get(s.charAt(i)));
            }
            max = Math.max(max,  i - slow + 1);
            map.put(s.charAt(i), i+1);
        }
        return max;
    }
}

