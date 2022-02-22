import java.util.HashMap;

// TC O(Order.length + S.length)
// SC O(S.length)
public class CustomSort {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            Character ch = order.charAt(i);
            if (count.containsKey(ch)) {
                int val = count.get(ch);
                for (int j = 0; j < val; j++) {
                    res.append(ch);
                }
                count.remove(ch);
            }
        }
        for (Character ch : count.keySet()) {
            int val = count.get(ch);
            for (int j = 0; j < val; j++) {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
