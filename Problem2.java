// Problem2 : Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)
    //Time complexity - O(n) Space - O(m) where m is the number of unique characters
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }

            if(s.length() == 1)
                return s.length();


            int start = 0, end = 0;
            int max = Integer.MIN_VALUE;
            int n = s.length();
            Set<Character> seen = new HashSet<>();
            while(start < n && end < n){
                char c = s.charAt(end);
                if(seen.contains(c)){
                    seen.remove(s.charAt(start++));

                }else{
                    max = Math.max(max, end - start + 1);
                    seen.add(s.charAt(end++));
                }
            }

            return max != Integer.MIN_VALUE ? max : end - start;
        }
    }