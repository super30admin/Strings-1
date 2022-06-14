using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class LengthOfLongestSubString
    {
        /// Time Complexity : O(n) 
        // Space Complexity :O(n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public int LengthOfLongestSubstring(string s)
        {
            int maxLength = 0;

            Dictionary<char, int> map = new Dictionary<char, int>();
            for (int fast = 0, slow = 0; fast < s.ToCharArray().Length; fast++)
            {
                if (map.ContainsKey(s.ToCharArray()[fast]))
                {
                    slow = Math.Max(map.GetValueOrDefault(s.ToCharArray()[fast]), slow);
                }
                maxLength = Math.Max(maxLength, fast - slow + 1);
                map[s.ToCharArray()[fast]] = fast + 1;
            }
            return maxLength;
        }
    }
}
