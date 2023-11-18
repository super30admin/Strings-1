public class CustomSortStringOrder
	{
        // Time Complexity : O(m + n), where m is the length of order string and n is the length of source string
        // Space Complexity : O(1) - constant space as there could be maximum 26 characters in hashmap
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public string CustomSortString(string order, string s)
        {
            Dictionary<char, int> map = new Dictionary<char, int>();
            for(int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (map.ContainsKey(c))
                {
                    map[c]++;
                }
                else
                {
                    map.Add(c, 1);
                }
            }
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < order.Length; i++)
            {
                char c = order[i];
                if(map.ContainsKey(c))
                {
                    int count = map[c];
                    for(int k = 0; k < count; k++)
                    {
                        result.Append(c);
                    }
                    map.Remove(c);
                }
            }
            foreach (var c in map)
            {
                int count = map[c.Key];
                for (int k = 0; k < count; k++)
                {
                    result.Append(c.Key);
                }
            }
            return result.ToString();
        }
    }
