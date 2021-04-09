import java.util.HashMap;
//tc : O(m + n); m = s.length(); n = t.length();
//sc : O(n); bcz of StringBuilder length; hashmap will have constant length of 26.
public class CustomSortString {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            if (map.containsKey(curr)) {
                int val = map.get(curr);
                for (int k = 0; k < val; k++) {
                    sb.append(curr);
                }
                map.remove(curr);
            }
        }

        for (char c : map.keySet()) {
            int v = map.get(c);
            for (int j = 0; j < v; j++) {
                sb.append(c);
            }

        }

        return sb.toString();
    }
}
