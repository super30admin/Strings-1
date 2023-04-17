// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Store each element into the map. If element already exists, move the slow pointer to the latest frequency of the character. 
 * Return i pointer - slow pointer + 1 as the length. 
 */

class Problem1 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        for(int i= 0; i < s.length();i++){
            Character ch = s.charAt(i);
            if(map.containsKey(ch)){
                slow = Math.max(slow,map.get(ch)+1);
            }
            map.put(ch, i);
            max = Math.max(max, i-slow+1);
        }
        return max;
    }
}