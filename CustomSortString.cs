using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    public class CustomSortString
    {
        /*
         * T.C: O(M+N) where m is length of order and n is length of s
         * S.C: O(1) 
         */
        public string GetCustomSortString(string order, string s)
        {
            if (order == null || order.Length == 0) return s;

            Dictionary<char, int> map = new Dictionary<char, int>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (map.ContainsKey(c))
                {
                    int cnt = map[c];
                    map[c] = cnt + 1;
                }
                else
                {
                    map.Add(c, 1);
                }
            }

            for (int i = 0; i < order.Length; i++)
            {
                char c = order[i];

                if (map.ContainsKey(c))
                {
                    int cnt = map[c];
                    Console.WriteLine(cnt);
                    while (cnt > 0)
                    {
                        sb.Append(order[i]);
                        cnt--;
                    }
                    map.Remove(c);
                }

            }

            foreach (char key in map.Keys)
            {
                int cnt = map[key];

                while (cnt > 0)
                {
                    sb.Append(key);
                    cnt--;
                }

            }

            return sb.ToString();
        }
    }
    }
}
