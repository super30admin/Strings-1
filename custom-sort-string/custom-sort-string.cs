public class Solution {
    public string CustomSortString(string S, string T) {
        StringBuilder sb = new StringBuilder(T.Length);
        int[] tchars = new int[26];
        
        foreach(var c in T)
        {
            tchars[c -'a']++;
        }
        
        foreach(var ch in S)
        {
            sb.Append(ch,tchars[ch -'a']);
            tchars[ch -'a'] =0;
        }
        
        for(int i=0;i< tchars.Length;i++)
        {
            sb.Append((char)(i+'a'),tchars[i]);
        }
        
        return sb.ToString();
        
        
    }
}
