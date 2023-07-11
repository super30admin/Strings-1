import java.util.HashMap;

public class CustomSort {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (map.containsKey(ch)) {
                int cnt = map.get(ch);
                for (int j = 0; j < cnt; j++) {
                    sb.append(ch);
                }
            }
            map.remove(ch);
        }
        for (char ch : map.keySet()) {
            int count = map.get(ch);
            for (int k = 0; k < count; k++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSort solution = new CustomSort();

        String order = "cba";
        String s = "abcdabc";

        String sortedString = solution.customSortString(order, s);

        System.out.println("Sorted String: " + sortedString);
    }
}