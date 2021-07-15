class Solution {
    public String customSortString(String order, String str) {
        StringBuilder result=new StringBuilder();
        if(str==null || str.length()==0)    return result.toString();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<order.length();i++)
        {
            char c=order.charAt(i);
            if(map.containsKey(c))
            {
                int cnt=map.get(c);
                while(cnt>0)
                {
                    result.append(c);
                    cnt--;
                }
                map.remove(c);
            }
        }
        for(char c:map.keySet())
        {
         int cnt=map.get(c);
         while(cnt>0)
        {
            result.append(c);
            cnt--;
        }
            // map.remove(c);   
        }
        
        return result.toString();
    }
}
//time compleixty: O(m+n)
//space complexity: O(1)