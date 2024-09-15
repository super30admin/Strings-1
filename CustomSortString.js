class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : T.toCharArray()){
            if(!map.containsKey(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        StringBuilder str = new StringBuilder();
        
        for(char c :S.toCharArray()){
            if(map.containsKey(c)){
                for(int i=0;i<map.get(c);i++){
                    str.append(c);
                }
                map.remove(c);
            }
        }
        
        for(char c : map.keySet()){
            for(int i=0;i<map.get(c);i++){
                str.append(c);
            }
        }
        
        return str.toString();
             
    }
}