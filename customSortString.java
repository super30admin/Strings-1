// Time Complexity :O(m+n)
// Space Complexity :O(n) (string builder)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.HashMap;

public class customSortString {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(s,0)+1);
        }

        for(char c:order.toCharArray()){
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int i=0; i<cnt; i++){
                    res.append(c);
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet()){
            int cnt = map.get(c);
            for(int i=0; i<cnt; i++){
                res.append(c);
            }
        }
        return res.toString();
    }
}
