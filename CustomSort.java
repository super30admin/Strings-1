// Time Complexity : O(length(s) + length(order))
// Space Complexity : O(length(s))
// Method used : Hashing

class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> map = new HashMap();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < order.length(); i++)
        {
            char c = order.charAt(i);

            if(map.containsKey(c))
            {
                int value = map.get(c);

                for(int k = 0; k < value; k++) result.append(c);

                map.remove(c);

            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            for(int i = 0; i < entry.getValue(); i++) result.append(entry.getKey());
        }

        return result.toString();
    }
}