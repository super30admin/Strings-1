//TC:O(N+M)
//SC:O(1)

class Solution {
    public String customSortString(String S, String T) 
    {
      int count[] = new int[26];
      for(int i=0;i<T.length();i++)
          count[T.charAt(i)-'a']++;
          
      String s = "";
      for(int i=0;i<S.length();i++)
      {
           int t = count[S.charAt(i)-'a'];
           for(int j=0;j<t;j++)
           {
               s=s+S.charAt(i);
               count[S.charAt(i)-'a']--;    
           }
      }
        
        for(int i=0;i<26;i++)
        {
          int t = count[i];
          for(int j=0;j<t;j++)  
            s=s+(char)(i+'a');
        }
        
        return s;
    }
}