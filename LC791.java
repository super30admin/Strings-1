//Time Complexity : O(m+n)
//Space Complexity :O(1)

class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)+1);
            }
            else
            {
                map.put(c,1);
            }
        }
        
        //System
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<order.length();i++)
        {
            char ch = order.charAt(i);
            
            if(map.containsKey(ch))
            {
                int freq = map.get(ch);
                
                for(int j=0;j<freq;j++)
                {
                    sb.append(ch);
                }
            }
            
            map.remove(ch);
        }
        
        for (char char1 : map.keySet())
        {
            int count = map.get(char1);
               
            for(int i=0;i<count;i++)
            {
                sb.append(char1);
            }
        }
        
        return sb.toString();
    }
}