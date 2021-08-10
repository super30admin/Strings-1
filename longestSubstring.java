
//SC: O(1)
//TC: O(N) where N is the length of string

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0)
            return 0;
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 0,slow = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //update slow
            if(map.containsKey(ch)){
                slow = Math.max(slow,map.get(ch));
            }
            //update index
            map.put(ch,i+1);
            maxLen = Math.max(maxLen,i-slow+1);
        }
        return maxLen;
    }
}