// TIME O(2n)
// SPACE O(1) hashset of lower case
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()==0)
            return 0;
        
        
        int result=0;
        int start=0, end=0;
        HashSet<Character> hashset=new HashSet<>();
        
        /* Go over the array and try to find substrings */
        while(start<s.length() && end<s.length())
        {            
            /* Check hashset to see if alphabet is there */
            if(hashset.contains(s.charAt(end)))
            {
                System.out.println(s.charAt(start));
                hashset.remove(s.charAt(start++));
            }
            else
            {
                System.out.println(s.charAt(end));
                hashset.add(s.charAt(end++));
                result=Math.max(result,end-start);
            }
        }
    
        return result;
    }
}