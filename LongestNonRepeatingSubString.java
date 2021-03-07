/**
  Time Complexity : O(length of String)
  Space Complexity : O(length of String)
  Two pointers, HashMap Excellent Question.
  Worked on leetcode :  YES
**/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int left = 0;
        int right;
        int currLen= 0;
        int maxLen = 0;
        
        for (right = 0;right< s.length();right++) {
            Character currentChar = s.charAt(right);
            if(!map.containsKey(currentChar)) {
                map.put(currentChar, right);
            } 
            else{
                currLen = right-left;
                maxLen = Math.max(currLen, maxLen);
                int index = map.get(currentChar);
                left = Math.max(left,index+1);
                map.put(currentChar, right);
                
            }
        }
        maxLen = Math.max(maxLen, right-left);
        return maxLen;
        
    }
}
