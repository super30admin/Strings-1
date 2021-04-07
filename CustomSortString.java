
// Time Complexity : O((m*n)+(m-n)) where m is the length of s and n is the lenght of t
// Space Complexity :O(m+n) where m is the length of s and n is the lenght of t
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String S, String T) {
      
      //take two lists and put the input strings in each
      List<Character> s = new ArrayList<>();
      List<Character> t = new ArrayList<>();
        for (char ch : S.toCharArray()) {
            s.add(ch);
        }
        for (char ch : T.toCharArray()) {
              t.add(ch);
        }
        //empty string to which we will append the characters whenever necessary
        String ans = "";
      
        for(int i=0;i<s.size();i++)
        {
          for(int j=0;j<t.size();j++)
          {
            //if element from s is present in t , append character from to the answer and remove it from the list
            if(s.get(i)==t.get(j))
            {
              ans = ans+s.get(i);
              t.remove(j);
              //as next of j would come to the current and we might skip it in the next iteration
              j--;

            }
          }
        //append everything remaing in t to the answer
        }
        for(int k=0;k<t.size();k++)
        {
            ans = ans + t.get(k);
        }
        
    return ans;
}
}