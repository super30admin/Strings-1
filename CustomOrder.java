// Time Complexity:O(m + n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * 1 - Create a HashMap by iterating over the string s and storing how many chars are present
 * 2 - Iterate over string order and append to the stringbuilder each char in order string if present in string s
 * for the count present against it in the HashMap. Remember, to remove the appended character from the HashMap
 * 3 - In the end, append the other remainder characters in the HashMap since we have to return a single permutation
 */

import java.util.HashMap;

public class CustomOrder {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++)
        {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length();i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                int count = map.get(c);
                while(count > 0)
                {
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(char key:map.keySet())
        {
            int count = map.get(key);
            while(count > 0)
            {
                sb.append(key);
                count--;
            }
        }
        
        return sb.toString();
    }
}
