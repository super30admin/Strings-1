//Time Complexity : O(maxLen(m,n))
//Space Complexity : O(maxLen(m,n))

//Approach

/*

    All the characters from String s are stored in hashmap. Now we iterate 
    through every character from Order String. We check if the character is there 
    in the hashmap or not. If yes, we copy the character the number of times it occurs 
    to the answer string. Once we are done copying according to the order String's order,
    we iterate and check if there are any more characters left in HashMap and copy them.

*/

import java.util.*;
public class CustomSortStrings
{
    public static String customSort(String order, String s)
    {
        if(order == null || order.length() == 0)
        {
            return s;
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0;i<s.length();i++)
        {
            char curr = s.charAt(i);

            map.put(curr,map.getOrDefault(curr,0)+1);
        }

        StringBuilder sb = new StringBuilder(); // final answer string

        for(int i =0;i<order.length();i++)
        {
            char c = order.charAt(i);

            if(map.containsKey(c))
            {
                int count = map.get(c);
                
                while(count>0)
                {
                    sb.append(c);
                    count--;
                }
            }

            map.remove(c);
        }

        for(char c: map.keySet())
        {
            int count = map.get(c);

            while(count>0)
            {
                sb.append(c);
                count--;
            }
        }

        return sb.toString();
    }

    public static void main(String args[])
    {
        String order = "cba";
        String s = "abcd";

        System.out.println(customSort(order, s));
    }
}