//Time Complexity : O(m+n) //m and n are sizes of input strings
//Space Complexity : O(26)

class Solution {
    public String customSortString(String order, String s) {

        //make a hasmap of char vs freq for source string
        HashMap<Character, Integer> map = new HashMap();

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        StringBuilder result = new StringBuilder();

        //iterate over the order
        for(int i=0; i<order.length(); i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                //get frequency of c
                int count = map.get(c);
                //append c that many times to result
                for(int j=0; j<count; j++)
                    result.append(c);
                map.remove(c);
            }
        }

        //append the remaining chars of source
        for(char c : map.keySet())
        {
            int count = map.get(c);
            for(int j=0; j<count; j++)
                result.append(c);
        }

        return result.toString();

    }
}
