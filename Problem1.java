
//T.C : O(n) where n is the size of the s string
//S.C : O(1) assuming there will be 26 alphabets in the hashmap
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
import java.util.HashMap;

public class Problem1 {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int freq = map.get(c);
                for(int j=0;j< freq;j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char c : map.keySet()){
            int freq = map.get(c);
            for(int j=0;j<freq;j++){
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
