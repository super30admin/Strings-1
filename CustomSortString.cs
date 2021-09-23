using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    class CustomSortStringLC
    {
        //TC: O(m+n)
        //SC: O(m)
        public string CustomSortString(string order, string s)
        {
            if (s == null || s.Length == 0)
            {
                return "";
            }
            Dictionary<char, int> map = new Dictionary<char, int>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                map.Add(c, map.GetValueOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < order.Length; i++)
            {
                char c = order[i];
                if (map.ContainsKey(c))
                {
                    int times = map[c];
                    for (int j = 0; j < times; j++)
                    {
                        sb.Append(c);
                    }
                    map.Remove(c);
                }
            }
            foreach (char c in map.Keys)
            {
                int times = map[c];
                for (int i = 0; i < times; i++)
                {
                    sb.Append(c);
                }
            }
            return sb.ToString();
        }
    }
}
