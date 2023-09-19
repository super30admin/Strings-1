class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character, Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(m.containsKey(s.charAt(i)))
            {
                m.put(s.charAt(i),m.get(s.charAt(i))+1);
            }
            else
            {
                m.put(s.charAt(i),1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++)
        {
            if(m.containsKey(order.charAt(i)))
            {
                int count = m.get(order.charAt(i));
                for(int v=0;v<count;v++)
                {
                    sb.append(order.charAt(i));
                }
                m.remove(order.charAt(i));
            }
        }
        for(Character c:m.keySet())
        {
            int count = m.get(c);
            for(int v=0;v<count;v++)
            {
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}