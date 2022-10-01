// Time Complexity : O(N)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Two pointer approach, maintain char and index map
whenever duplicate value is found and when left<=index then move the left pointer
keep calculating the window length
*/
public class LongestSubstringWithoutRepChar {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;

        int left=0;
        HashMap<Character,Integer> hm= new HashMap<>();
        int maxLen=0;
        for(int right=0;right<s.length();right++){
            char ch= s.charAt(right);
            if(hm.containsKey(ch) && left<=hm.get(ch)){
                left=hm.get(ch)+1;
            }
            maxLen=Math.max(right-left+1,maxLen);
            hm.put(ch,right);
        }
        return maxLen;
    }
}
