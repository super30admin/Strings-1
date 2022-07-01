import java.util.HashMap;
import java.util.Map;

//Time complexity : O(n)
//Space Complexity : O(1)
//Did it run on leetcode : yes

public class CustomSort {

    public String customSortString(String order, String s) {

        Map<Character, Integer> cMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for(char c : s.toCharArray()){
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(cMap.containsKey(c)){
                int count = cMap.get(c);
                for(int k = 0; k < count; k++){
                    result.append(c);
                }
                cMap.remove(c);
            }
        }
        //iterate on remaining keys of map
        for(char c : cMap.keySet()){
            int count = cMap.get(c);
            for(int k = 0; k < count; k++){
                result.append(c);
            }
        }
        return result.toString();
    }
}
