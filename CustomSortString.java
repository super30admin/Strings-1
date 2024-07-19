import java.util.HashMap;
import java.util.Map;

/***
 TC - O(m+n)
 Sc - O(1)
 */
class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch : order.toCharArray()) {
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                while(count-- > 0) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        for(char ch : map.keySet()) {
            int count = map.get(ch);
            while(count-- > 0) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}