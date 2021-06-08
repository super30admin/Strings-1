class Solution {
    //Time O(L) L --> length of sts
    //Space O(L)
    public String customSortString(String order, String str) {
        if(order == null || order.length() == 0)
        {
            return str;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<str.length() ;  i++)
        {
            char c = str.charAt(i);
            map.put(c , map.getOrDefault(c , 0)+1);
        }
        for(int i=0 ; i<order.length() ; i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                int count  = map.get(c);
                while(count > 0)
                {
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for(Character c : map.keySet())
        {
            int count = map.get(c);
            while(count > 0)
            {
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}