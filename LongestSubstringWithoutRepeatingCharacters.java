//Time: O(n)
//Space: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int max = 0;
        int slow = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int fast = 0; fast < s.length(); fast++){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, fast + 1);
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}
