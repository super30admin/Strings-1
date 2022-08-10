// Time Complexity: O(N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

// Your code here along with comments explaining your approach: Made HashMap and stored the 1st occurance with its index position, when the already existing alphabet comes at that time slow pointer find index from HaspMap and moves already existing alphabet + 1 index to avoid duplicate string within the longest substring

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0, max = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, i + 1);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}