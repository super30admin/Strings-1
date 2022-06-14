using System;
using System.Collections.Generic;
using System.Text;

namespace Algorithms
{
    public class CustomSortString
    {
        /// Time Complexity : O(n) 
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public string CustomSortString_1(string order, string s)
        {
            Dictionary<char, int> map = new Dictionary<char, int>();
            for (int i = 0; i < s.ToCharArray().Length; i++)
            {
                if (map.ContainsKey(s.ToCharArray()[i]))
                {
                    map[s.ToCharArray()[i]] = map.GetValueOrDefault(s.ToCharArray()[i]) + 1;
                }
                else
                {
                    map.Add(s.ToCharArray()[i], 1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < order.ToCharArray().Length; j++)
            {
                if (map.ContainsKey(order.ToCharArray()[j]))
                {
                    int charCount = map.GetValueOrDefault(order.ToCharArray()[j]);
                    while (charCount > 0)
                    {
                        sb.Append(order.ToCharArray()[j]);
                        charCount--;
                    }
                    map.Remove(order.ToCharArray()[j]);
                }
            }

            foreach (var item in map)
            {
                int charCount = item.Value;
                while (charCount > 0)
                {
                    sb.Append(item.Key);
                    charCount--;
                }
            }
            return sb.ToString();
        }
    }
}
