// Time O(n+m) where n is length of order and m is length of string
// Space O(m) where m is length of s
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer > h = new HashMap<>(); //frequency hashmap
        for(char c : s.toCharArray())   // input string
        {
            h.put(c, h.getOrDefault(c,0)+1);  //insert to hashmap
        }
        
        StringBuilder res= new StringBuilder();
        for(char o: order.toCharArray())
        {
            if(h.containsKey(o))      

            {
                int val = h.get(o);
                for(int i =0;i<val;i++)
                {res.append(o);}
                h.remove(o);
            }
            
        }
        
        for(Character c: h.keySet())
        {
            int val = h.get(c);
            for(int i =0;i<val;i++)
            {res.append(c);}
        }
        return res.toString();
    }
}