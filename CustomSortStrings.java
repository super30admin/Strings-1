// Time Complexity : O(m+n) where m is length of S and n is length of T
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String S, String T) {
        
        int [] charMap = new int[26];
        for(int i=0;i<T.length();i++)
        {
            charMap[T.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++)
        {
              while(charMap[S.charAt(i)-'a']>0)
              {
                  sb.append(S.charAt(i));
                  charMap[S.charAt(i)-'a']--;        
              }
        }
        
        for(int i=0;i<26;i++)
        {
          while(charMap[i]>0)
          {
                  sb.append(String.valueOf((char)(i + 97)));
                  charMap[i]--;        
          }
        }
        
        return sb.toString();
    }
}