import java.util.Map;

// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty() || "".equals(s))
            return 0;
        int slow = 0,fast = 0,max = 0;
        int size = s.length();
        Map<Character,Integer> map = new HashMap<>();
        while(fast < size){
            char ch = s.charAt(slow);
            if(map.containsKey(ch)){
                slow = Math.max(slow,map.get(ch));
                fast++;
            }
            map.getOrDefault(ch, fast + 1);
            fast++;
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}