import java.util.HashMap;
import java.util.Map;
//TC On SC Om m==size of order string

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hm = new HashMap();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Integer c = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), c + 1);
        }
        System.out.println(hm);
        for (int j = 0; j < order.length(); j++) {
            if (hm.containsKey(order.charAt(j))) {
                int h = hm.get(order.charAt(j));
                for (int k = 0; k < h; k++) {
                    sb.append(order.charAt(j));
                    hm.remove(order.charAt(j));
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet())
            for (int y = 0; y < entry.getValue(); y++) {
                sb.append(entry.getKey());
            }
        return sb.toString();
    }
}