// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //edge
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> hash = new HashMap<>();


        int slow = 0;
        int max = 0;



        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            //if hash contains curr char
            if(hash.containsKey(c)){
                slow = Math.max(slow, hash.get(c));
            }
            //max of current max and current slow plus 1 -ith index
            max = Math.max(max, i - slow + 1);
            //put the letter in map
            hash.put(c, i+1);
        }

        return max;
    }
}