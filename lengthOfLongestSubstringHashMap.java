//Time : O(2n)
//Space : O(n)
//Leetcode : Yes

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(null) || s.equals("")) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int slow = 0; int fast = 0; int max =1;
        while(fast<s.length()){
            char c  = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }
            map.put(c,fast+1);
            max = Math.max(max,fast-slow+1);
            fast ++;
        }
        
        return max;
        
    }
}