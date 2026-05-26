// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1) - there can be at most 26 chaacters in the frequency map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I first go over string s and create a frequencyMap of all the characters in the string. I then iterate over each character in the order string and check what it's frequency is in the frequency map. 
I then append that character frequency number of times to the resultant array and remove it from the map. After this, I traverse through all the remaining keys in the map and append them their respective
frequency number of times to the resultant string.
*/

public class Solution {
    public string CustomSortString(string order, string s) {
        StringBuilder result = new();
        Dictionary<char, int> frequencyMap = new();

        for(int i = 0; i < s.Length; i++)
        {
            frequencyMap[s[i]] = frequencyMap.GetValueOrDefault(s[i], 0) + 1;
        }

        int count = 0;

        for(int i = 0; i < order.Length; i++)
        {
            char ch = order[i];

            if(frequencyMap.ContainsKey(ch))
            {
                count = frequencyMap[ch];
                while(count>0)
                {
                    result.Append(ch);
                    count -= 1;
                }

                frequencyMap.Remove(ch);
            }
        }

        foreach(char key in frequencyMap.Keys)
        {
            count = frequencyMap[key];

            while(count>0)
            {
                result.Append(key);
                count -= 1;
            }
        }

        return result.ToString();
    }
}