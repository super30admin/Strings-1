// TC ==> O(m+n)
// SC ==> O(n) at max 26

public class Solution
{
    public string CustomSortString(string order, string s)
    {
        if (string.IsNullOrEmpty(order) || string.IsNullOrEmpty(s))
        {
            return string.Empty;
        }

        Dictionary<char, int> lookup = new Dictionary<char, int>();

        foreach (char c in s)
        {
            lookup.TryAdd(c, 0);
            lookup[c]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.Length; i++)
        {
            if (lookup.ContainsKey(order[i]))
            {
                for (int j = 0; j < lookup[order[i]]; j++)
                {
                    sb.Append(order[i]);
                }
                lookup.Remove(order[i]);
            }
        }

        foreach (var kv in lookup)
        {
            for (int j = 0; j < kv.Value; j++)
            {
                sb.Append(kv.Key);
            }
        }
        return sb.ToString();
    }
}