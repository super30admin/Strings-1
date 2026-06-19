//Time Complexity: O(n + m)
//Space Complexity: O(1)

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> sMap = new HashMap<>();

        for(char c: s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
        }

        StringBuilder sb = new StringBuilder();

        for(char c: order.toCharArray()) {
            if(sMap.containsKey(c)) {
                int cnt = sMap.get(c);
                for(int i = 0; i < cnt; i++) {
                    sb.append(c);
                }
                sMap.remove(c);
            }
        }

        for(char c: sMap.keySet()) {
            int cnt = sMap.get(c);
            for(int i = 0; i < cnt; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}