// tc O(n)
//sc O(n)

import java.util.HashMap;

public class CustomSortString {

}
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer > map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) +1);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < order.length() ; i ++){
            char ch =order.charAt(i);
            if(map.containsKey(ch)){
                int cnt = map.get(ch);
                for(int k =0 ; k < cnt ; k++){
                    result.append(ch);
                    map.remove(ch);
                }
            }
        }

        for(Character c : map.keySet()){
            int cnt = map.get(c);
            for(int k =0 ; k < cnt ; k++){
                result.append(c);

            }
        }

        return result.toString();

    }
}