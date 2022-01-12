// Time Complexity: O(m+n) iterate over both order and string
// Space Complexity: O(m) -> O(1) since only 26 chars
public class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        if(order == null || order.length() == 0)
            return ans.toString();
        
        Map<Character, Integer> map = new HashMap<>();
        
        // put count of each char of s in map
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // take the pattern of order and replace each char by the count in map
        for(char c : order.toCharArray())
        {
            if(map.containsKey(c))
            {
                int times = map.get(c);
                for(int i = 0 ; i < times; i++)
                {
                    ans.append(c);
                }
                // remove the value
                map.remove(c);
            }
        }
        
        // check if any char left in map append it
        for(Character c : map.keySet())
        {
            int times = map.get(c);
            for(int i = 0 ; i < times; i++)
            {
                ans.append(c);
            }
        }
            
            
        return ans.toString();
    }
}
