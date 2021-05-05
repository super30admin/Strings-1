// Runtime complexity - O(n) where n is the length of the string T
// Space complexity - O(1) where hashmap contains maximum of 26 lowercase alphabets, so constant space

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:T.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder str=new StringBuilder();
        for(char c:S.toCharArray())
        {
            if(map.containsKey(c))
            {
                int count=map.get(c);
                for(int i=0;i<count;i++)
                {
                    str.append(c);
                }
                map.remove(c);
            }
        }
        for(char c:map.keySet())
        {
            int count=map.get(c);
            for(int i=0;i<count;i++)
            {
                str.append(c);
            }
            //map.remove(c);               
        }
        return str.toString();
        
    }
}
