
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Sliding Window
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int res=0;
        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right)),left);
            }
            map.put(s.charAt(right),right+1);
            res=Math.max(res,right-left+1);
            System.out.println(right-left+1);
        }
        return res;
    }
}



