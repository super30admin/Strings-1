//time : O(m+n)
//space : result space of O(T.length);
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(char c: T.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c: S.toCharArray())
        {
            if(map.containsKey(c))
            {
               int count= map.get(c);
                while(count>0)
                {
                   sb.append(c);
                    count--;
                }
                System.out.println(sb);
                map.remove(c);
            }
        }
        for(Map.Entry<Character, Integer> entry:map.entrySet())
        {
            int count=entry.getValue();
            char key=entry.getKey();
            System.out.println(key);
            while(count>0)
            {
                sb.append(key);
                count--;
            }
           
        }
        
     return sb.toString();
    }
}
