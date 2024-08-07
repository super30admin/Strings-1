import java.util.HashMap;

public class CustomSort {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int k =0;k<cnt;k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for(char c:map.keySet()){
            int cnt = map.get(c);
            for(int k =0;k<cnt;k++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
