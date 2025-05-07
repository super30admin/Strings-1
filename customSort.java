// Time: O(m + n), Space: O(n)
// m = length of order, n = length of s

/*  Approach:
    1. Count frequency of characters in string `s` using a HashMap.
    2. Append characters in the `order` string based on their frequency in `s`.
    3. Append remaining characters in `s` that were not in `order`.
*/

import java.util.*;
public class customSort 
{
    public String customSortString(String order, String s) {
        StringBuilder op = new StringBuilder();
        char[] ord = order.toCharArray();
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<ch.length;i++)
        {
            if(map.containsKey(ch[i]))
            {
                int get = map.get(ch[i]);
                map.put(ch[i],get+1);
            }
            else
            {
                map.put(ch[i],1);
            }
        }
        for(int i=0;i<ord.length;i++)
        {
            if(map.containsKey(ord[i]))
            {
                int size = map.get(ord[i]);
                while(size!=0)
                {
                    op.append(ord[i]);
                    size--;
                }
                map.remove(ord[i]);
            }
        }
        for(Map.Entry<Character,Integer> m : map.entrySet())
        {
            int size = m.getValue();
            while(size!=0)
            {
                op.append(m.getKey());
                size--;
            }
        }
        return op.toString();
    }
}
