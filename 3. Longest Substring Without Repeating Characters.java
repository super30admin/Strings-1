class Solution {
    // Time complexity: O(n)
    // Space complexity: O(s.length)
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();
        
        while(r < s.length()){
            
            while(set.contains(chars[r])){
                set.remove(chars[l++]);
            }
            set.add(chars[r]);
            
            max = Math.max(max, r - l + 1);
            
            r++;
        }
        
        return max;
    }
}