Time Complexity: o(m+n)
Space Complexity: o(max(m,n))
class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        if(S.length()==0 || T.length() ==0) return sb.toString();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < T.length(); i++)
        {
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i<S.length(); i++)
        {
            char C = S.charAt(i);
            if(map.containsKey(C))
            {
                while(map.get(C) > 0) {
                    sb.append(C);
                    map.put(C, map.get(C) -1 );
                }
                map.remove(C);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            char c = entry.getKey();
            int count = entry.getValue();
            while(count>0)
            {
                sb.append(c);
                count--;
            }
            
        }
        return sb.toString();
        
    }
}