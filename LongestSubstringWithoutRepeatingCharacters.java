// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int left = 0;
        int right = 0;
        int max = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        while(right < s.length()) {     
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        
        return max;
    }
}