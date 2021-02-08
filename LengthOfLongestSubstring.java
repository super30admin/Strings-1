// Time Complexity : The time complexity is O(n) where n is the length of String
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;

        int maxLength = Integer.MIN_VALUE;

        while(end < s.length()){

            char c = s.charAt(end);

            // The characters from start to end should be unique
            if(!map.containsKey(c) || map.get(c) < start){
                map.put(c,end);
                maxLength = Math.max(maxLength,end-start+1);
            }
            // If the character already exists, move the start
            else{
                start = map.get(c)+1;
                map.put(c,end);
            }
            end++;

        }

        return maxLength;

    }
}