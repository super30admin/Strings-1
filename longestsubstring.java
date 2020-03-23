# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set st = new HashSet();
        while(j < s.length()){
            if(!st.contains(s.charAt(j))){
                st.add(s.charAt(j++));
                max = Math.max(max, st.size());
            }
            else{
                st.remove(s.charAt(i++));
            }
        }
        return max;
}
}