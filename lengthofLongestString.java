// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//TC:O(2n)=O(n)
//SC: O(min(m,n))
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)return 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int end = 0, start = 0;
        while(end<s.length()){
            char ch = s.charAt(end);
            if(hashmap.containsKey(ch))
                //to concentrate on:
                start = Math.max(start , hashmap.get(ch));
            hashmap.put(ch , end + 1);
            max = Math.max(max, end-start + 1);
            end++;
        }
        return max;
    }
}