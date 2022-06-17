// Time Complexity :O(n) where n is elngth of s string
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashSet<Character> sSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
            sSet.add(c);
        }
        for (int i = 0; i < order.length(); i++) {
            char o = order.charAt(i);
            if (smap.containsKey(o)) {
                int count = smap.get(o);
                while (count != 0) {
                    sb.append(o);
                    count--;
                }
                sSet.remove(o);
            }
        }
        if (!sSet.isEmpty()) {
            for (char c : sSet) {
                int count = smap.get(c);
                while (count != 0) {
                    sb.append(c);
                    count--;
                }
            }
        }
        return sb.toString();
    }
}