import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> occurrencesMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            occurrencesMap.put(c, occurrencesMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (occurrencesMap.containsKey(c)) {
                int count = occurrencesMap.get(c);
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                occurrencesMap.remove(c);
            }
        }

        for (char c : occurrencesMap.keySet()) {
            int count = occurrencesMap.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }

        return sb.toString();
    }
}

//TC: O(m+n), SC: O(m) - for StringBuilder and toString

