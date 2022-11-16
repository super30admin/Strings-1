import java.util.HashMap;

// Time Complexity:O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * We use sliding window technique combined with a HashMap. 
 * 1. Have a slow and a fast(i) pointer. At every point, check if the char is present in the map.
 * 2. If the char is present, move the slow pointer to that index + 1 and calculate max
 * 3. If the char is not present, add the char to the HashMap and calculate max. In the end, return max
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        int slow = 0;
        int max = 0;
        for(int i = 0; i < s.length();i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                slow = Math.max(slow,map.get(c));
            }
            max = Math.max(max,i - slow + 1);
            map.put(c,i + 1);
        }
        return max;
    }
}