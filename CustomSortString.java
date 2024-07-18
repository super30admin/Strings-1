import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String s) {
        if(order.isEmpty() || s.isEmpty()) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                for(int j=0; j<count; j++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            for(int i=0; i<entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
