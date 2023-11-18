public class LongestNonRepeatingSubstring
	{
        // Time Complexity : O(n), where n is the length of the string
        // Space Complexity : O(1) - constant space as there could be maximum 26 characters in hashmap
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int LengthOfLongestSubstring(string s)
        {
            Dictionary<char, int> map = new Dictionary<char, int>();
            int slow = 0;
            int fast = 0;
            int maxLength = 0;
            for(int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (map.ContainsKey(c))
                {
                    slow = Math.Max(slow, map[c] + 1);
                    map[c] = i;
                }
                else
                {
                    map.Add(c, i);
                }
                maxLength = Math.Max(maxLength, i - slow + 1);
            }
            return maxLength;
        }
    }
