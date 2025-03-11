class CustomSort {
    public String customSortString(String order, String s) {
        if(order == null || order.length() ==0 || s==null || s.length()==0)
        return s;


        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<order.length();i++)
        {
            char ch = order.charAt(i);
            if(map.containsKey(ch))
            {
                int count  = map.get(ch);
                while(count>0)
                {
                    sb.append(ch);
                    count--;
                }
                map.remove(ch);
            }
        }
        for(Character key: map.keySet())
        {
            int count = map.get(key);
            while(count>0)
                {
                    sb.append(key);
                    count--;
                }
               
        }
        return sb.toString();
    }
}


///Time Complexity (TC): O(n+m), where n is the length of s and m is the length of order.
//Space Complexity (SC): O(n), where n is the length of s.