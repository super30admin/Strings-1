import java.util.HashMap;
import java.util.Map;


//TC: O(m+n)
//Sc: O(1)
class CustomSortStrings {
    public String customSortString(String order, String s) {
        if(order==null || s==null || order.length()==0 || s.length()==0){
            return s;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);   
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<order.length();i++){
            char ch=order.charAt(i);
            if(map.containsKey(ch)){
                for(int j=0;j<map.get(ch);j++){
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        //keys which are not in order string
        for(Character key:map.keySet()){
            int cnt=map.get(key);
            while(cnt>0){
                sb.append(key);
                cnt--;
            }
        }
        return sb.toString();
    }
}

