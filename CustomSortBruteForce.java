
// Time Complexity : O(M*N)
// Space Complexity : O(1) as hasmap only contains 26 characters
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach  BRUTE FORCE
1) we use a hashmap on String s and not on order as order contains only unique characters and we would miss out the occurences on each character.
2) We store the occurences of each character in String s in map
3) once we do that, we iterate over String order and check in map if it contains the character, if yes we append that many times in the hashmap
4) once we exi the order loop 
5) we need to append for remaining characters as well.
*/

import java.util.*;
class CustomSortBruteForce {
    public String customSortString(String order, String s) {
        
        Map<Character,Integer> map = new HashMap<>();
        
        
        // putting s in map as it contains duplicate characters as well
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            
        }
        
        // iterate over order to map the actual order i. string builder 
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<order.length();i++)
        {
            if(map.containsKey(order.charAt(i)))
            {
                int times = map.get(order.charAt(i));
                for(int j=0;j<times;j++)
                {
                    sb.append(order.charAt(i));
                }
                
                map.remove(order.charAt(i));
            }
            
        }
        
        // to append remaining characters in map
        
        
        for(char c: map.keySet())
        {
            int times =map.get(c);
            for(int j=0;j<times;j++)
            {
                sb.append(c);
            }
        }
        
        
        return sb.toString();
    }
}