
// TC : O(nlogn) //n = s.length
// SC : O(1)

package S30_Codes.Strings_1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CustomSortString {

    public String customSortString(String order, String s) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        Character[] sArr = new Character[s.length()];
        for(int i=0; i<s.length(); i++){
            sArr[i] = s.charAt(i);
        }

        // Arrays.sort(sArr, Comparator.comparingInt(c -> orderMap.getOrDefault(c, order.length()))
        Arrays.sort(sArr, (c1, c2) ->
                orderMap.getOrDefault(c1, order.length()) - orderMap.getOrDefault(c2, order.length())
        );

        StringBuilder sb = new StringBuilder();
        for(char c : sArr){
            sb.append(c);
        }

        return sb.toString();
    }
}