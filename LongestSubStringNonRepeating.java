class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Run time -: O(n)
        
        if (s == null || s.length() == 0) return 0;
        
        int slow = 0;
        int fast = 0;
        int max = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        while (fast < s.length()){
            Character c = s.charAt(fast);
            if (map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, fast + 1);
            max = Math.max(max,fast-slow+1);
            fast++;
        }
        return max;
        
    }
}