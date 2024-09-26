import java.util.HashMap;

//Space - O(m+n)
//Time  - O(1) length of string. but can be constant as ints 26

// Add string to hashmap with char as key and value as number of times it repeats
// loop over the order to see if they are i nthe map and if found append to the stringbuilder. and remove from map
// at the end loop over leftover chars in map. and append them to the string builder. at the end conver t to string and return

public class CustomSortStrings {
    public String customSortString(String order, String s) {
        if (order == null || s == null)
            return null;

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int j = 0; j < order.length(); j++) {
            char c = order.charAt(j);
            if (map.containsKey(c)) {
                int size = map.get(c);
                for (int k = 0; k < size; k++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for (char key : map.keySet()) {
            int size = map.get(key);
            for (int i = 0; i < size; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }

}
