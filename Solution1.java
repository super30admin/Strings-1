// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I maintain a map with character as key and it's occurrences as value. I iterate through the order string and check the map for each
 * character as it appears in it and append it the number of times it's present. After appending each character for the given number of times,
 * I remove it from the map. Then I add the rest of the characters of the string s.
 */

 class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<order.length();i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                int count = map.get(c);
                for(int k=0;k<count;k++)
                {
                    result.append(c);
                }
            }
             map.remove(c);
        }
        for(char c : map.keySet())
        {
            int count = map.get(c);
            for(int k=0;k<count;k++)
            {
                result.append(c);
            }
        }
        return result.toString();

    }
}