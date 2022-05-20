
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    //TC: O(n), SC: O(1)
    public int LengthOfLongestSubstring(string s) {
        
        if(String.IsNullOrEmpty(s))
            return 0;
        
        Dictionary<char, int> dict = new Dictionary<char, int>();
        int start = 0, end = 0, result = 0;
        
        //we use two pointers start and end as sliding window
        //and use hashmap to save visited characters and their indexes
        while(end < s.Length)
        {
            char ch = s[end];
            if(dict.ContainsKey(ch))
            {
                //we take maximum of current or start element
                //because if there are repeating string in middle, then if we go back, it will take repeating elements somewhere in substring
                start = Math.Max(dict[ch] + 1, start);
                dict[ch] = end;
            }
            else
            {
                dict.Add(ch, end);
            }
            result = Math.Max(result, end - start + 1);
            end++;
        }
        
        return result;
    }
}