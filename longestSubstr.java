class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        int slow=0;
        int max=0;
        
        for(int fast=0; fast<s.length(); fast++){
            char c= s.charAt(fast);
            if(map.containsKey(c)){
                slow= Math.max(slow, map.get(c));
            }
            max = Math.max(max, fast-slow+1);
            map.put(c, fast+1);
        }
        
        return max;
    }
}
