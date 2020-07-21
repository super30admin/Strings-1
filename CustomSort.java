Execeutd in leet code-yes
Time complexity-o(m+n)

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char c: T.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        StringBuilder st= new StringBuilder();
         for(char c: S.toCharArray()){
            if(map.containsKey(c)){
                int ct=map.get(c);
                while(ct>0){
                    st.append(c);
                    ct--;
                }
                map.remove(c);
            }
                
        }
         for(char c: map.keySet()){
                int ct=map.get(c);
                while(ct>0){
                    st.append(c);
                    ct--;
                }
        }
        return st.toString();
    }
}
