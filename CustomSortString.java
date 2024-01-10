
//Time complexity : O(m) , m -> Length of s
//Space complexity : O(m) , because of StringBuilder
import java.util.HashMap;

public class CustomSortString {
    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        String result = customSortString(order, s);
        System.out.println(result);
    }

    private static String customSortString(String order, String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (hmap.containsKey(c)) {
                int cnt = hmap.get(c);
                for (int k = 0; k < cnt; k++) {
                    sb.append(c);
                }
                hmap.remove(c);
            }
        }
        for (char c : hmap.keySet()) {
            int cnt = hmap.get(c);
            for (int k = 0; k < cnt; k++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}