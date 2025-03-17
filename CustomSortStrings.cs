// time complexity - O(m+n)
// space complexity - o(1)
public class Solution
{
    public string CustomSortString(string order, string s)
    {
        Dictionary<char, int> dict = new Dictionary<char, int>();
        StringBuilder sb = new StringBuilder();
        foreach (var ch in s) // O(n)
        {
            if (dict.ContainsKey(ch))
            {
                dict[ch]++;
            }
            else
            {
                dict.Add(ch, 1);
            }
        }
        foreach (var ch in order) // O(m)
        {
            if (dict.ContainsKey(ch))
            {
                while (dict[ch] > 0)
                {
                    sb.Append(ch);
                    dict[ch]--;
                }
                dict.Remove(ch);
            }
        }
        foreach (var ch in dict) // O(n)
        {
            while (dict[ch.Key] > 0)
            {
                sb.Append(ch.Key);
                dict[ch.Key]--;
            }
        }
        return sb.ToString();
    }
}