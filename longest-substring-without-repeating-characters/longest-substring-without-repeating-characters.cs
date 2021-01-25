public class Solution {
    public int LengthOfLongestSubstring(string s) {
        HashSet<char> h = new HashSet<char>();
        
        int j=0;
        int max =0;
        int i=0;
        
        for(;i<s.Length;i++)
        {
            if(h.Contains(s[i]))
            {
                while(true)
                {
                    char t = s[j];
                    h.Remove(t);
                    max = Math.Max(max,i-j);
                    j++;
                    if(t==s[i])
                    {
                        break;
                    }
                }
            }
            
            h.Add(s[i]);
            max = Math.Max(max,i-j);
        }
        return Math.Max(max,i-j);
        
    }
}
