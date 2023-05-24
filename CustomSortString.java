import java.util.HashMap;

//Leetcode - 791
//Time Complexity - O(N)
//Space Complexity - O(N) - for StringBuilder
public class CustomSortString {

    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i<order.length();i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                for(int j=0;j<count;j++) {
                    result.append(ch);
                }
                map.remove(ch);
            }
        }
        for(Character ch : map.keySet()) {
            int count = map.get(ch);
            for(int j=0;j<count;j++) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
