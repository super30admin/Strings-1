class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength=0, slow=0, fast=0;
        while(fast<s.length() && slow< s.length()){
            if(!set.contains(s.charAt(fast))){
                set.add(s.charAt(fast));
                fast++;
                maxLength= Math.max(maxLength,fast-slow);
            }else{
                set.remove(s.charAt(slow));
                slow++;
            }
        }
            return maxLength;
    }
}