//TC: O(m+n)
//SC: O(n)

import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();

        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int k =0;k<cnt;k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char c :map.keySet()){
            int cnt = map.get(c);
            for(int k =0;k<cnt;k++){
                sb.append(c);
            }
            //we cannot do map remove here while traversing on the map itself
        }

        return sb.toString();
    }
}