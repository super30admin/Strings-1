import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow =0;
        int max =0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                slow = Math.max(slow, map.get(c)+1);
            }
            map.put(c, i);
            max = Math.max(max, i-slow+1);
        }
        return max;
    }
}