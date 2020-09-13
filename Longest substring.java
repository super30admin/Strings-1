// Time complexity - 0(n)
// space complexity- 0(n)
// code successfully executed in leetcode

class Solution {
    public int lengthOfLongestSubstring(String s) {
   
        if(s== null || s.length() == 0 ) return 0;
        int low=0;
        int high =0;
        int max =0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(high < s.length()){
            Character c = s.charAt(high);
            if(map.containsKey(c)){
                low = Math.max(low,map.get(c));
            }
            map.put(c,high+1);
            max = Math.max(max,(high-low+1));
            high++;
        }
        return max;
    }
}