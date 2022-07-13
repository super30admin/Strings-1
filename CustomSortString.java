import java.util.HashMap;
import java.util.Map;
// Time Complexity: O(order.length + s.length)
// Space Complexity: O(s.length) for StringBuilder
public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i < s.length() ;i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                while(cnt > 0){
                    res.append(c);
                    cnt--;
                }
                map.remove(c);
            }
        }
        for(char key: map.keySet()){
            int cnt = map.get(key);
            while(cnt > 0 ){
                res.append(key);
                cnt--;
            }
        }
        return res.toString();
    }
}
