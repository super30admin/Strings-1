using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    class LongestSubStringWithOutRepeat
    {
        //TC: O(n)
        //SC: O(1)
        public int LengthOfLongestSubString(string s)
        {
            if (s == null || s.Length == 0)
            {
                return 0;
            }
            Dictionary<char, int> map = new Dictionary<char, int>();
            int slow = 0;
            int max = int.MinValue;
            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (map.ContainsKey(c))
                {
                    slow = Math.Max(slow, map[c]);
}
                map.Add(c, i + 1);
                max = Math.Max(max, i - slow + 1);
            }
            return max;
        }
    }
}
