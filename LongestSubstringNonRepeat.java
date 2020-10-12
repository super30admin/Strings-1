// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//we shall do using sliding window concept with two pointers start and end
//we shall extend end till we find valid substring and put char and its next index in hashmap
//then we move start forward and when char is already in hashmap, update start to that index comparing to the start(to avoid backward loop)
//maintain the max length substring each time and return it after the loop.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap<Character, Integer> hm=new HashMap<>();
        int start=0;
        int end=0;
        int len=Integer.MIN_VALUE;
        
        while(end<s.length()){
            char ch=s.charAt(end);
            if(hm.containsKey(ch)){
                start=Math.max(start,hm.get(ch));
            }
            hm.put(ch,end+1);
            len=Math.max(len,end-start+1);
            end++;
        }
        return len;
        
        
    }
}