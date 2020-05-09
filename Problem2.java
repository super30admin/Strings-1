// Time Complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        } 
        int slow = 0;
        int fast = 0;
        int max = 0;
        HashMap<Character, Integer> tracker = new HashMap<>();
        
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(tracker.containsKey(c)){
                slow = Math.max( slow, tracker.get(c));
            }
            tracker.put(c, fast+1);       
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        return max;
    }
}
