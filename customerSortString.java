// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Store the character from string s in a map. 
 * Then according to the order, get all the counts from map and add it to the result string.
 */
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i  = 0 ; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < order.length(); i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                int count = map.get(c);
                for(int j = 0 ; j < count; j++)
                {
                    result.append(c);
                }
                map.remove(c);
            }
        }

        //key which are not in the order
        for(char c: map.keySet())
        {
            int count = map.get(c);
            for(int j = 0 ; j< count; j++)
            {
                result.append(c);
            }
        }

        return result.toString();
    }
}