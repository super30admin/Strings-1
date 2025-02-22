import java.util.HashMap;

public class CustomString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char c : s.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c, 0) +1);
        }
        StringBuilder sb = new StringBuilder("");
        for(char c : order.toCharArray()){
            int times = hmap.getOrDefault(c,0);
            for(int i=0;i<times;i++){
                sb.append(c);
            }
            hmap.remove(c);
        }
        for(char c : hmap.keySet()){
            int times = hmap.getOrDefault(c,0);
            for(int i=0;i<times;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
