using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    public class LongestString
    {
        /*
         * T.C: O(N) where n is length of string
         * S.C: O(1) since at the most only 26 char will get saved in the dictionary/map
         */
        public int LengthOfLongestSubstring(string s)
        {
            if (s == null || s.Length == 0)
                return 0;

            int slow = 0;
            int max = 0;
            int start = 0;
            int end = 0;
            Dictionary<char, int> map = new Dictionary<char, int>();

            for (int fast = 0; fast < s.Length; fast++)
            {
                char c = s[fast];
                if (map.ContainsKey(c))
                {
                    if (slow < map[c])
                    {
                        slow = map[c];
                    }
                }
                if (max < fast - slow + 1)
                {
                    max = fast - slow + 1;
                    start = slow;
                    end = fast;
                }
                map[c] = fast + 1;

            }

            Console.WriteLine(s.Substring(start, end - start));



            return max;

        }
    }
}
