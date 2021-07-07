// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String S, String T) {
        if(S == null || S.length() == 0){
            return T;
        }

        if(T == null){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : T.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(char c : S.toCharArray()){
            if(map.get(c) != null){
                int n = map.get(c);
                for(int i = 0 ; i < n; i++){
                    sb.append(c);
                }
            }
            map.remove(c);
        }

        if(map.keySet() == null){
            return sb.toString();
        } else {
            for(char c: map.keySet()){
                int n = map.get(c);
                for(int i = 0 ; i < n; i++){
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}
