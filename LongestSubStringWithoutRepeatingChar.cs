//time complexity - with set - O(2n), with Dictionary - O(n)
//Space complexity - O(n)
public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        int start = 0;
        int end = 0;
        Dictionary<char, int> chars = new Dictionary<char, int>();
        int maxLength = 0;
        HashSet<char> set = new HashSet<char>();
        // using set
        // while(end < s.Length && start<=end)
        // {
        //     if(set.Contains(s[end]))
        //     {
        //         while(set.Contains(s[end]))
        //         {
        //             set.Remove(s[start]);
        //             start++;
        //         }
        //     }
        //     set.Add(s[end]);

        //     end++;
        //     maxLength = Math.Max(maxLength,set.Count());
        // }
        // using dictionary
        for (int i = 0; i < s.Length; i++)
        {
            Console.WriteLine($"Inside while");
            if (!chars.ContainsKey(s[i]))
            {
                chars.Add(s[i], i);
            }
            else
            {
                if (start <= chars[s[i]])
                {
                    start = chars[s[i]] + 1;
                }
                chars[s[i]] = i;
            }
            maxLength = Math.Max(maxLength, (i - start + 1));
        }
        return maxLength;
    }
}