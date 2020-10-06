//Time Complexity-O(n+m)
//Space Complexity-O(1)
class Solution {
    public String customSortString(String S, String T) {
        if(S==null ||
          T==null||
          S.length()==0||
          T.length()==0)
        {
            return " ";
        }
        HashMap<Character,Integer>map=new HashMap();
        StringBuilder output=new StringBuilder();
        for(int i=0;i<T.length();i++)
        {
            char c=T.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);            
        }
        for(int i=0;i<S.length();i++)
        {
            char c=S.charAt(i);
            if(map.containsKey(c))
            {
                int count=map.get(c);
                while(count>0)
                {
                    output.append(c);
                    count--;
                }
            }
            map.remove(c);
        }
        for(Map.Entry<Character,Integer> mapElement:map.entrySet())
        {
            char c=mapElement.getKey();
            int count=mapElement.getValue();
            while(count>0)
            {
                output.append(c);
                count--;
            }
        }
        return output.toString();
        
    }
}