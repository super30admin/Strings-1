//TC: O(m+n)
//SC:O(1)
class Solution2 {
    public String customSortString(String order, String s) {
        //get the frequency map for source string
        HashMap<Character,Integer> hmap=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
            //get the index if key already exists or assign 0
            //increment that inex by 1 to record its current count
            //O(m)
        }
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<order.length();i++)
        {
            //o(n)
            char c=order.charAt(i);
            if(hmap.containsKey(c))
            {
                //get freq
                count=hmap.get(c);
            
                for(int k=0;k<count;k++)
                {
                    //append the char with that much fre to target
                    sb.append(c);
                }
            }
            hmap.remove(c);
        }
        //append remaining chars to start or end of trarget string
        for(char key:hmap.keySet())
        {
             count=hmap.get(key);
            for(int x=0;x<count;x++)
            {
                sb.append(key);
            }
        }
        return sb.toString();
        
    }
}