// Time Complexity :  O(max(order length 26 constant  and String length))
// Space Complexity : O(26) //constant
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// First we build a freq map on the string and then we iterate on the order if that char is present then we append it to the sb
// and remove that entry from the map, now we can iterate on the keyset of the map and add the characters as per the freq from the map.

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        }
       
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++)
        {
            char c= order.charAt(i);
            if(hmap.containsKey(c))
            {
                int count = hmap.get(c);
                for(int j=0;j<count;j++)
                {
                    sb.append(c);
                }
                hmap.remove(c);
            }
        }

        for(char c: hmap.keySet())
        {
            int count = hmap.get(c);
            for(int j=0;j<count;j++)
            {
                sb.append(c);
            }
            // hmap.remove(c);  we cant remove here as it will give a concurrent action error
        }

        //  System.out.println(hmap);
        // String a="aaa";
        return sb.toString();
    }
}