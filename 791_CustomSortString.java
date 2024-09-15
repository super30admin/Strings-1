class Solution {
    public String customSortString(String S, String T) {
        
        //base case
        if(T == null || T.length() == 0)
            return null;
        
        if(S == null || S.length()==0 )
            return T;
        
        HashMap<Character, String> map = new HashMap<>();
        
        for(int i=0; i<T.length(); i++)
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), "") + T.charAt(i));
        
        StringBuilder str = new StringBuilder();
        for(int i=0; i<S.length(); i++)
        {
            if(map.containsKey(S.charAt(i)))
            {
                str.append(map.get(S.charAt(i)));
                map.remove(S.charAt(i));
            }
        }
        for(char ch: map.keySet())
            str.append(map.get(ch));
        
        return str.toString();
    }
}