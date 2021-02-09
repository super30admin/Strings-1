// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Time complexity : O(n)
// Space complexity : O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int curr = 0;
        int high = s.length();
        int max = 0;
        HashMap<Character,Integer> seen = new HashMap<>();
        while(curr < high){
            char c = s.charAt(curr);
            if(!seen.containsKey(c)){
                max = Math.max(max, curr-low + 1);
            }else{
                int prev_occurence = seen.get(c);
                while(low <= prev_occurence){
                    seen.remove(s.charAt(low++));
                }
            }
            seen.put(c, curr);
            curr++;
        }
        return max;
    }
}