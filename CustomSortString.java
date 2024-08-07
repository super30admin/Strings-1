// Time Complexity : O(s) - s is length of String
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char o : order.toCharArray()) {
            if(map.containsKey(o)) {
                int count = map.get(o);
                for(int i = 0; i < count; i++) {
                    res.append(o);
                }
                map.remove(o);
            }
        }

        for(char c : map.keySet()) {
            int count = map.get(c);
            for(int j = 0; j < count; j++) {
                res.append(c);
            }
        }

        return res.toString();
    }
}