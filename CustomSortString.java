// TC: O(m + n)
// SC: O(n)
class Solution {
    public String customSortString(String order, String str) {
        if(str == null) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                while(count > 0) {
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }

        for(char key : map.keySet()) {
            int count = map.get(key);
            while(count > 0) {
                sb.append(key);
                count--;
            }
        }

        return sb.toString();
    }
}