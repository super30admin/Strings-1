/*
This solution uses a hashmap to keep track of all the characters in the string, and then orders the characters
using the order string, subsequently generating a custom sorted result.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(m + n) linear in order of lengths of s and order
    //Space Complexity: O(1) constant because we use a hashmap that will only have 26 entries in the worst case
    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c, 0) + 1);
        }
        //Adding the characters to the result string according to sorted order from the order string
        for(int i = 0; i < order.length(); i++)
        {
            char c = order.charAt(i);
            
            if(map.containsKey(c))
            {
                int count = map.get(c);
            
                for(int j = 0; j < count; j++)
                    result.append(c);

                map.remove(c);
            }
        }
        //Adding the rest of the characters in the string to the result string
        for(char c : map.keySet())
        {
            int count = map.get(c);
            
            for(int j = 0; j < count; j++)
                result.append(c);
        }
        
        return result.toString();
    }
}