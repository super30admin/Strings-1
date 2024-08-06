//TC: O(n)
//SC: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                slow = Math.max(map.get(c) + 1, slow);
            } 
            max = Math.max(i - slow + 1, max);
            map.put(c, i);
        }
        return max;
    }
}
