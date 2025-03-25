class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()== 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) >= start){
                    max = Math.max(max , i - start);
                    start = map.get(c) + 1;
                }
            }
            map.put(c, i);
        }
        max = Math.max(max , s.length() - start);
        return max;
    }
}
// HashMap, 2 Pointer
// TC: O(n)
// SC: O(n)
