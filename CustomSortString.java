
public class CustomSortString {
    public String customSortString(String order, String s) {
        if (order == null || order.length() == 0) {
            return s;
        }
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char single = s.charAt(i);
            map.put(single, map.getOrDefault(single, 0) + 1);
        }

        for (int i = 0; i < order.length(); i++) {
            char single = order.charAt(i);
            if (map.containsKey(single)) {
                int times = map.get(single);
                for (int j = 0; j < times; j++) {
                    answer.append(single);
                }
                map.remove(single);
            }
        }

        if (!map.isEmpty()) {
            for (char c : map.keySet()) {
                int times = map.get(c);
                for (int j = 0; j < times; j++) {
                    answer.append(c);
                }
            }
        }
        return answer.toString();
    }
}
