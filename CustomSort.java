import java.util.HashMap;
import java.util.Map;

public class CustomSort {

    // TC: O(m + n) m - length of order string   n - length of s string
    // SC: O(1)
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0) return s;

        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i=0; i < order.length();i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }

        }

        // Leftover characters
        // Just append to the StringBuilder as their order doesn't matter
        map.forEach((k,v) -> {
            int count = v;
            while(count > 0) {
                sb.append(k);
                count--;
            }
        });

        return sb.toString();
    }
}
