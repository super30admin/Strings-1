//approach-
//tc - O(n)
//sc- O(1)

class Solution {
    public String customSortString(String order, String s) {
        
        if(s == null || s.length() == 0) return "";
        
        HashMap<Character, Integer> map =new HashMap<>();
        String result = "";
        //put string charcter into map
        
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        //now traverse through order
        for(int j=0; j<order.length(); j++)
        {
            char c = order.charAt(j);
            if(map.containsKey(c))
            {
                int count = map.get(c);
                //System.out.println("key = "+c+ "  value = "+count);
                while(count>0)
                {
                    result = result+c;
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(char c : map.keySet())
        {
            int count = map.get(c);
                while(count>0)
                {
                    result = result+c;
                    count--;
                }
            
        }
        return result;
    }
}