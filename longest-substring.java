// Time Complexity : O(n)
// Space Complexity : O(1) hashmap takes constant space
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int pivot = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                pivot = Math.max(map.get(c), pivot);
            }
            map.put(c, i + 1);
            maxCount = Math.max(maxCount, i - pivot + 1);
        }
        return maxCount;
    }
}