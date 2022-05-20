
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public string CustomSortString(string order, string s) {
        
    if(String.IsNullOrEmpty(s) || String.IsNullOrEmpty(order))
        return s;
    
    Dictionary<char, int> dict = new Dictionary<char, int>();
    
    //Build hamsap of char and count of S
    foreach(char c in s)
    {
        if(dict.ContainsKey(c))
            dict[c] += 1;
        else
            dict.Add(c, 1);
    }
    
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < order.Length; i++)
    {
        char c = order[i];
        // If char is present in hashmap, put in result and repeat it based on count, remove from hasmap
        if(dict.ContainsKey(c))
        {
            int cnt = dict[c];
            while(cnt > 0)
            {
                sb.Append(c);
                cnt--;
            }
            dict.Remove(c);
        }
    
    }
    //Then go over hasmap, take them and put in result based on count
    foreach(char c in dict.Keys)
    {
        int cnt = dict[c];
        while(cnt > 0)
        {
            sb.Append(c);
            cnt--;
        }
    }
    return sb.ToString();
}