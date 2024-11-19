class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int max=0;
        int slow=0,fast=0;
        while(fast<s.length()){
            char in = s.charAt(fast);
            if(set.contains(in)){
                while(set.contains(in)){
                    char out=s.charAt(slow);
                    set.remove(out);
                    slow++;
                }
            }
            max=Math.max(max,fast-slow+1);
            set.add(in);
            fast++;
        }
        return max;
    }
}
