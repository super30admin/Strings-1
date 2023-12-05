// Time Complexity : O(s) where s is the length string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CustomSort {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap();
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c : order.toCharArray())
        {
            if(map.containsKey(c))
            {
                for(int i = 1; i <= map.get(c); i++)
                {
                    ans.append(c);
                }
                map.remove(c);
            }
        }
        for(char c : map.keySet())
        {
            for(int i = 1; i <= map.get(c); i++)
            {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
