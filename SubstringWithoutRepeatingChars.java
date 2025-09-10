// This solution uses a map for referring to the last seen index of a character. If at all any point the last seen is before the slow pointer, we just ignore it otherwise move the slow pointer after that index
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1) return s.length();
        Map<Character, Integer> map = new HashMap();
        int low = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int val = map.get(c);
                if(val>=low) {
                    low = val+1;
                } 
            }
            max = Math.max(max, i-low+1);
            map.put(c, i);
        }
        return max;
    }
}

