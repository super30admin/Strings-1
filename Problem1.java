// Time Complexity : O(n) where n is the size of s
// Space Complexity : O(1) constant space as the map will always be a constant max size of 26 (number of alphabets)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0){
            return s;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int j = 0; j < count; j++){
                    str.append(c);
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet()){
            int count = map.get(c);
            for(int i = 0; i < count; i++){
                str.append(c);
            }
            //map.remove(c);
        }

        return str.toString();
    }
}
