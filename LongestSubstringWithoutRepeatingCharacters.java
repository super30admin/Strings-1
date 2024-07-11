// Time Complexity : O(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Track Character Positions: The code uses a hashmap to store the latest positions of characters in the string s.
//Adjust Start Position: As it iterates through the string, if a character is repeated, it adjusts the starting position of the current substring to ensure no duplicates.
//Calculate Max Length: The code keeps track of and updates the maximum length of the substring without repeating characters as it processes each character.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start =0;
        int max=0;
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch));
            }
            map.put(ch, i+1);
            max= Math.max(max, i-start+1);
        }
        return max;
    }
}