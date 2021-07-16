// Time: O(n) where n is the length of s
// Space: O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int slow =0, fast = 0, max=0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c,i+1);
            max = Math.max(max, i-slow+1);
        }      
        return max;
    }
}

