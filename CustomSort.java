// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public String customSortString(String order, String s) {

        if(s == null || s.length() == 0)
            return s;

        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        StringBuilder res = new StringBuilder();

        for(int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int val = map.get(ch);
                while(val > 0) {
                    res.append(ch);
                    val--;
                }
            }
            map.remove(ch);

        }

        for(char key: map.keySet()) {
            int val = map.get(key);
            while(val > 0) {
                res.append(key);
                val--;
            }
        }


        return res.toString();
    }
}