// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int max=0;
        int pos = 0;
        for (int i=0; i<s.length(); i++){
            if (hm.containsKey(s.charAt(i))){
                pos = Math.max(pos,hm.get(s.charAt(i))+1);
            }
            hm.put(s.charAt(i),i);
            max = Math.max(max,i-pos+1);
        }
        return max;
    }
}