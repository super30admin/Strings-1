class Solution {
    public String customSortString(String order, String str) {

        Map<Character, Integer> map = new HashSet<>();

        for (int i=0; i<order.length(); i++) {
            if (!map.contains(order.charAt(i))) {
                map.put(order.charAt(i), 0);
            } else {
                map.put(order.charAt(i), map.get(charAt(i)) + 1);
            }
        }

        StringBuilder string = new StringBuilder<>();
        for (int i=0; i<order.length(); i++) {
            string.append(order.charAt(i));
        }

        for (int i=0; i<str.length(); i++) {
            if (map.get(str.charAt(i)) == 0 || !map.contains(str.charAt(i))) {
                string.append(str.charAt(i));
            } else {
                map.put(order.charAt(i), map.get(charAt(i)) - 1);
            }
        }

        return string.toString();

    }
}