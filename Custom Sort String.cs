/*
  Time complexity: O(n)
  Space complexity: O(n)

  Code ran successfully on leetcode: Yes
*/

public class Solution {
    public string CustomSortString(string order, string s) {
        Dictionary<char,int> dict = new();
        StringBuilder result = new();
        foreach(char c in s)
        {
            if(!dict.ContainsKey(c))
                dict.Add(c,0);
            
            dict[c]++;
        }
        foreach(char o in order)
        {
            if(dict.ContainsKey(o))
            {
                while(dict[o]>0)
                {
                    result.Append(o);
                    dict[o]--;
                }
                dict.Remove(o);
            }
        }

        foreach(var keyVal in dict)
        {
            while(dict[keyVal.Key]>0)
            {
                result.Append(keyVal.Key);
                dict[keyVal.Key]--;
            }
        }

        return result.ToString();
    }
}
