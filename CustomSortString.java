import java.util.HashMap;

//Time Complexity: O(n + m) where n is the length of s and m is the length of order
//Space Complexity: O(n) where n is the length of s
public class CustomSortString {

    // Space could've been 0(1) but we are using an intermediate Stringbuilder so it
    // will become O(n)
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        // populate countmap with s
        for (Character ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // traverse order and append based on count of ch in map and then remove
        // occurence from map
        for (Character ch : order.toCharArray()) {
            if (countMap.containsKey(ch)) {
                int count = countMap.get(ch);
                for (int j = 0; j < count; j++) {
                    sb.append(ch);
                }
                countMap.remove(ch);
            }
        }

        // if there are any chars left in map append them, again based on their counts
        if (countMap.size() > 0) {
            for (Character ch : countMap.keySet()) {
                int count = countMap.get(ch);
                for (int j = 0; j < count; j++) {
                    sb.append(ch);
                }

            }
        }

        return sb.toString();
    }
}