class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length()==0)
        {
            return s;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder result= new StringBuilder();
        for(int i=0;i<order.length();i++)
        {
            if(!map.containsKey(order.charAt(i)))
            {
                continue;
            }
            int count= map.get(order.charAt(i));
            map.remove(order.charAt(i));

            while(count>0)
            {
                result.append(order.charAt(i));
                count--;
            }
        }
        for(char key : map.keySet())
        {
            int remainingcount=map.get(key);
            while(remainingcount>0)
            {
                result.append(key);
                remainingcount--;
            }

        }
        return result.toString();

    }
}