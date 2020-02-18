//TC - O(m + n)
//SC - O(m + log(n))

class Solution {
    
    class Custom
    {
        char c;
        int idx;
        
        Custom(String s, int i)
        {
            c = s.charAt(i);
            idx = i;
        }
    }
    
    public String customSortString(String S, String T) {
        if(S == null || T == null || S.length() == 0 || T.length() == 0) return "";
        
        HashMap<Character, Integer> tmap = new HashMap<>();
        
        PriorityQueue<Custom> pq = new PriorityQueue<>((a,b) -> a.idx - b.idx);
        
        for(int i = 0; i < T.length(); ++i)
        {
            if(!tmap.containsKey(T.charAt(i)))
                tmap.put(T.charAt(i), 1);
            else
                tmap.put(T.charAt(i), tmap.get(T.charAt(i)) + 1);
        }
        
        for(int i = 0; i < S.length(); ++i)
            pq.add(new Custom(S, i));
        
        String res = "";
        
        while(!pq.isEmpty())
        {
            Custom t = pq.poll();
            
            if(tmap.get(t.c) != null)
            {
                int count = tmap.get(t.c);
                tmap.remove(t.c);

                for(int i = 0; i < count; ++i)
                {
                    res += t.c;
                }
            }
        }
        
        for(char k : tmap.keySet())
        {
            int count = tmap.get(k);
            
            for(int i = 0; i < count; ++i)
            {
                res += k;
            }
        }
        
        return res;
    }
}
