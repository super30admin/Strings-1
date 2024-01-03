import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        // TC:O(m+n)
        // SC:O(1)
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int freq = map.get(c);
                for(int k = 0; k < freq; k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char key: map.keySet()){
            int freq = map.get(key);
            for(int k = 0; k < freq; k++){
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
