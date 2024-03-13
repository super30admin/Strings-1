// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int lengthOfLongestSubstring(String st) {
         HashMap< Character, Integer> map = new HashMap<>();
        int s = 0;
        int m = 0;
        for(int i = 0; i < st.length(); i++){
            char c = st.charAt(i);
            if(map.containsKey(c)){
                s = Math.max(s , map.get(c) + 1);
            }
            map.put(c, i);
            m = Math.max(m , i - s + 1);
        }
        return m;
    }
}