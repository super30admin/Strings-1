//TC : O(n) n = length of string s
//SC : O(n) used by stringBuilder
class Solution {
    public String customSortString(String order, String s) {
        if(order==null||order.length()==0) return s;

        HashMap<Character,Integer> hm = new HashMap();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        for(int i=0;i<order.length();i++)
        {
            char c = order.charAt(i);
            if(hm.containsKey(c))
            {
                int count = hm.get(c);
                for(int j=0;j<count;j++)
                {
                    sb.append(c);
                }
                hm.remove(c,count);
            }
        }

        for(char c : hm.keySet())
        {
            int count = hm.get(c);
            for(int j=0;j<count;j++)
            {
                sb.append(c);
            }

        }
        return sb.toString();
    }
}