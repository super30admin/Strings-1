//Time : O(m+n)
//Space : O(1)

class Solution {

    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < order.length(); j++) {
            if (map.containsKey(order.charAt(j))) {
                int k = map.get(order.charAt(j));
                // System.out.println(k);
                while (k > 0) {
                    sb.append(order.charAt(j));
                    k--;
                }
                map.remove(order.charAt(j));
            }
        }
        for (char c : map.keySet()) {
            int z = map.get(c);
            while (z > 0) {
                sb.append(c);
                z--;
            }
        }

        return sb.toString();
    }
}
