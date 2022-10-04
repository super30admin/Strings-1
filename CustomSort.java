class Solution {
    //tc - o(n)
    //sc -0(1)
    public String customSortString(String order, String s) {
        HashMap <Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< s.length();i++)
        {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) +1);
        }

        for(int i=0;i<order.length();i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
             int count = map.get(c);
             for(int k=0;k<count;k++)
             {
                sb.append(c);
             }
            }
            map.remove(c);
            
        }
        //append rest of the elemets
        for(Character c : map.keySet())
        {        
            int count = map.get(c);
            for(int k=0;k<count;k++)
            {
                sb.append(c);
            }
            //if we add the below it will give error because map.keyset will change on removal
            // map.remove(c);
        }
        return sb.toString();
    }
}