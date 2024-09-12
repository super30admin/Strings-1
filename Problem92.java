// Time Complexity - O(n)
// Space Complexity - O(k)  // k = max length of substring

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int slow=0, fast=0, ans=0;

        while(fast<s.length()){
            while(set.contains(s.charAt(fast))){
                set.remove(s.charAt(slow++));
            }
            set.add(s.charAt(fast++));
            ans = Math.max(ans, fast-slow);
        }
        return ans;
    }
}