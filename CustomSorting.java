/**
S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T
 so that they match the order that S was sorted. More specifically, if x occurs before y in S, 
 then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

S = "cba"
T = "abcd"
Output: "cbad"

Time Complexity : O(N)
Space Complexity : O(N+M)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution
{
    public String customSortString(String S, String T) 
    {
        Map<Character, Integer> hashMap = new HashMap<>();
        
        StringBuilder stbr = new StringBuilder();
        
        for( int i =0 ; i < T.length(); i++)
        {
            char ch = T.charAt(i);
            
            hashMap.put( ch, hashMap.getOrDefault( ch, 0) + 1);
        }
        
        for( int i =0; i< S.length(); i++)
        {
            char ch = S.charAt(i);
            
            if(hashMap.containsKey( ch))
            {
                int count = hashMap.get( ch);
                
                for( int j = 0; j< count; j++)
                {
                    stbr.append( ch);
                }
                
                hashMap.remove(ch);
            }
        
        }
        
        for( char ch: hashMap.keySet())
        {
            int count = hashMap.get( ch);
            
            for( int j =0 ;j < count; j++)
            {
                stbr.append( ch);
            }
            
        }
        
        
        return stbr.toString();
        
        
    }
}