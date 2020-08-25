// TIME - O(n) where n is max(size(S),size(T))
// SPACE - O(1)


class Solution {
    public String customSortString(String S, String T) {
        
        
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        
        /* HashMap over T  O(1) space */
        for(int i=0;i<T.length();i++)
        {
            char c=T.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        /* GO over S */
        for(int i=0;i<S.length();i++)
        {
            char c=S.charAt(i);
            if(map.containsKey(c))
            {
                int count=map.get(c);
                for(int j=0;j<count;j++)
                {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        
        /* Go over remaining elements */
        for(char c : map.keySet())
        {
            int count=map.get(c);
            for(int j=0;j<count;j++)
            {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}