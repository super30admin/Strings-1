import java.util.HashMap;
import java.util.Map;

//time complexity: O(N)
//space complexity: O(N) -> new HashMap defined
public class CustomSortString {
    public String customSortString(String order, String s) {

        Map<Character, Integer> occurrences = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            occurrences.put(s.charAt(i), occurrences.getOrDefault(s.charAt(i), 0)+ 1);
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i< order.length(); i++){
            if(occurrences.containsKey(order.charAt(i))){
                for(int k = 0; k< occurrences.get(order.charAt(i)); k++){
                    str.append(order.charAt(i));
                }
                occurrences.remove(order.charAt(i));
            }
        }

        for(char ch: occurrences.keySet()){
            int ctr = occurrences.get(ch);
            for(int c = 0; c< ctr; c++){
                str.append(ch);
            }
        }

        return str.toString();

    }
}
