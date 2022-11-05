// TC : O(n)
// SC : O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        HashMap<Character, Integer> hMap = new HashMap<>();
        int fast = 0, slow = 0;
        int n = s.length();
        int max = Integer.MIN_VALUE;
        while(fast < n) {
            
            char c = s.charAt(fast);
            if(hMap.containsKey(c)) {
                if(hMap.get(c) > slow)
                    slow = hMap.get(c);
            }
            hMap.put(c, fast+1);
            fast++;
            max = Math.max(max, (fast - slow));
        }
        return max;
    }
}
