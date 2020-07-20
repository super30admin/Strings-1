import java.util.Map;

import java.util.HashMap;

public class Custom_Sorting{
    public String customSortString(String S, String T) {
        // return null;
        
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0 ;i < T.length();i++){
            char c = T.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c, map.get(c)+1);
        }
        
        
        for(int j = 0;j < S.length();j++){
            char c = S.charAt(j);
            if(map.get(c) != null){
                int count = map.get(c);
                for(int i=0;i< count;i++){
                    sb.append(c);
                }        
            }
            map.remove(c);
        }
        
        
        for(char c  : map.keySet()){
            int count =  map.get(c);
            for(int i=0;i< count;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}