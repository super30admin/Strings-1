// Time Complexity : O(n)
// Space Complexity : O(1) - position map can have at most 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain two pointers - start and end. Initially, both are set to 0. I start traversing through string s until end != s.Length. I check if the character present at end index in string s is 
present in the positionMap - if not I add the character along with it's position/index in the string. If yes, I check if the index of the character already present in the map is greater than/equal to 
start, if so I set start to the index recorded for that charater in the map + 1. Then I update the index for that character with end. I keep track of the maximum length of end-start+1 for each iteration
and return that maximum at the end.
*/

public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int result = 0;
        int start = 0, end = 0;
        Dictionary<char, int> positionMap = new();

        while(end < s.Length)
        {
            if(positionMap.ContainsKey(s[end]))
            {
                if(positionMap[s[end]] >= start)
                {
                    start = positionMap[s[end]] + 1;
                }

                positionMap[s[end]] = end;
            }

            else
            {
                positionMap[s[end]] = end;
            }

            result = Math.Max(result, end - start + 1);

            end++;
        }

        return result;
    }
}