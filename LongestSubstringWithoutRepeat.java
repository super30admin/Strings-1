// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// use sliding window approach by starting from i=0 find max substring length starting from index i, add chars to set
// max substring length == set size, if we encounter duplicate, move i

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans=0, i=0, j=0;
        
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        
        return ans;
    }
}