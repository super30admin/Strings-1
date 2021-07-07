# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No





class Solution {
    public int lengthOfLongestSubstring(String s) {
       if(s == null) return 0;
        int maxLen = 0;
        int start = 0;
        int end = 0;
        Set <Character> set = new HashSet();

        while(end < s.length()){
            char ch = s.charAt(end);
            while(set.contains(ch)){
                set.remove(s.charAt(start));
                start++;

            }

            set.add(ch);
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;


}
}