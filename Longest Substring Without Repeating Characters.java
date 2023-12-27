//  Time Complexity: O(n)
//  Space Complexity: O(1) -> Hash size would be number of characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, i;
        int result = 0;
        for(i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c)){
                left = map.get(c) + 1 > left ? map.get(c) + 1 : left ;
            }
            map.put(c,i);
            result = Math.max(i - left + 1, result);
        }
        return result;
        
    }
}