import java.util.HashMap;
import java.util.Map;

//TC: O(N)
//SC: O(1), map will only contain 26 elements at max
public class CustomSortString {

    public String customSortString(String order, String s) {
        final Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);

        final StringBuilder builder = new StringBuilder();
        for (char ch: order.toCharArray()) {
            if (frequency.containsKey(ch)) {
                int count = frequency.get(ch);
                for (int i = 0; i < count; i++) builder.append(ch);
                frequency.remove(ch);
            }
        }

        for (Character ch: frequency.keySet()) {
            int count = frequency.get(ch);
            for (int i = 0; i < count; i++) builder.append(ch);
        }

        return builder.toString();
    }
}
