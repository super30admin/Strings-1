/*
 * 
 * Time complexity : O(n)
 * Space Complexity : O(n)
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int slow = 0;
        int fast = 0;
        int max = Integer.MIN_VALUE;
        while(fast < s.length()){
            char ch = s.charAt(fast);
            if(map.containsKey(ch)){
                slow = Math.max(slow, map.get(ch));
            }
            
            map.put(ch, fast+1);
            
            max = Math.max(max, (fast - slow)+1);
            
            fast++;
        }
        
        return max;
        
    }
}