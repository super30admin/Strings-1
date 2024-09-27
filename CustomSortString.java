//Time Complexity: O(n)
//S[ace Complexity: O(n)
class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: T.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()) {
            if(map.containsKey(c)) {
                for(int i = 0; i < map.get(c); i++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        if(map.size() > 0) {
            for(char c: map.keySet()) {
                for(int i = 0; i < map.get(c); i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}