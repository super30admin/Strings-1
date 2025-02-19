import java.util.HashMap;

//TC: O(m+n)
//SC: O(1)
//791. Custom Sort String
class customSortString {
    public String customSortString(String order, String s) {
        if (order == null || order.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int frequency = map.get(c);
                for (int j = 0; j < frequency; j++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            for (int j = 0; j < frequency; j++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}