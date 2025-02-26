//TC => O(n)
//SC => O(n)

public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        if (s == null || s.Length == 0)
        {
            return 0;
        }

        int max = Int32.MinValue;
        int start = 0;
        Dictionary<char, int> lookup = new Dictionary<char, int>();

        for (int i = 0; i < s.Length; i++)
        {
            if (lookup.ContainsKey(s[i]))
            {
                start = Math.Max(start, lookup[s[i]]);
                lookup[s[i]] = i + 1;
            }
            else
            {
                lookup.Add(s[i], i + 1);
            }
            max = Math.Max(i - start + 1, max);

        }
        return max;
    }
}