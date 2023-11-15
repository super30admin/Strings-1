// Time Complexity : O(n*l)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class CustomSortString {
    class Solution {
        public String customSortString(String order, String s) {
            int orderLen = order.length();
            int sLen = s.length();

            Map<Character, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < sLen; i++){
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for(int i = 0; i < orderLen; i++){
                char c = order.charAt(i);
                if(map.containsKey(c)){
                    int count = map.get(c);
                    while(count > 0){
                        sb.append(c);
                        map.put(c, map.get(c) - 1);
                        count--;
                    }
                }
                map.remove(c, 0);
            }

            for(char c : map.keySet()){
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                    count--;
                }
            }

            return sb.toString();
        }
    }
}
