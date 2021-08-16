class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        String ans = "";

        for(int i=0 ; i<s.length() ; i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        for(int i=0 ; i<order.length() ; i++)
        {
            if(map.containsKey(order.charAt(i)))
            {
                int size = map.get(order.charAt(i));

                    for(int j=0 ; j<size ; j++)
                    {
                        ans = ans + order.charAt(i);
                    }

                map.remove(order.charAt(i));
            }
        }

        for(char c : map.keySet())
        {
            int size = map.get(c);

            for(int j=0 ; j<size ; j++)
            {
                ans = ans + c;
            }
        }

        return ans;

    }
}
