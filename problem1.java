//## Problem1 Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

// Time Complexity : O(order.length + s.length)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//approach: populated a hashmap with all the characters in s and their frequency. iterated thru order, if the hashmap had the character from order, created a string with the corresponding character with it's frequency, added all such occurences. At the end, dumped all the remaining characters from s to the created string.

class Solution {
    public String customSortString(String order, String s) {

        if( order == null || order.length()==0)
        {
            return s;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb =new StringBuilder();

        for(int i =0 ; i< s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i=0;i<order.length();i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                int times= map.get(c);
                for(int j = 0; j<times;j++)
                {
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet())
        {
            int times = map.get(c);
            for(int j = 0; j<times;j++)
            {
                sb.append(c);
            }
        }

        return sb.toString();
        
    }
}