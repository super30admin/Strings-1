// Time Complexity :O(n) 
// Space Complexity :Maximum length of substring without repeating character
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach




class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = 0;
        int i=0,j=0;
        
        Set<Character> set = new HashSet();
        
        while(i < s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}
