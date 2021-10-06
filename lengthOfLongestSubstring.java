// Time Complexity - O(n) where n is the length of the input string
// Space Complexity - O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        
        for(int high=0; high<s.length(); high++){
            char c = s.charAt(high);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, high+1);
            
            result = Math.max(result, high-slow+1);
        }
        
        return result;
    }
}