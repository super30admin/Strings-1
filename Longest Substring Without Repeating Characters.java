// HashMap Solution
// Time Complexity = O(n)
// Space Complexity = O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                  
                slow = Math.max(slow, map.get(ch) + 1);
            }
            map.put(ch, i);
            count = Math.max(count, i-slow +1);
            
        }
        return count;
    }
}