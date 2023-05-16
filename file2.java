/*
    Time Complexity - O(n) where n is the size of the string s.
    Space complexity - O(n) unique characters in s are stored in data structure. In worst case all characters in s could be unique.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, max = 0, res= 1;
        for(char c: s.toCharArray()){
            if(map.containsKey(c))
                max = Math.max(max, map.get(c)+1);
            res = Math.max(res, count-max+1);
            map.put(c, count);
            count++;
        }
        return res;
    }
}
