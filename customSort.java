class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            if(hmap.containsKey(c)){
                hmap.put(c, hmap.getOrDefault(c,0) + 1);
            }else{
                hmap.put(c, 1);
            }
        }
        
        StringBuilder Str = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char a = S.charAt(i);
            if(hmap.containsKey(a)){
                int count = hmap.get(a);
                while(count > 0){
                    Str.append(a);
                    count--;
                }
                hmap.remove(a);
            }
                
        }  
        
        for(char c : hmap.keySet()){
            int a = hmap.get(c);
            while(a > 0){
                Str.append(c);
                a--;
            }
        }
        
        return Str.toString();
        
    }
}