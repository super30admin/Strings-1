// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // create map of frquency of chars in s
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        StringBuilder sb = new StringBuilder();

        // loop through order and if char is in map, add to sb number of times in s
        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int k=0; k<cnt; k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        // add remaining chars (in s but not order) add in any order
        for(char c : map.keySet()){
            int cnt = map.get(c);
            for(int k=0; k<cnt; k++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
