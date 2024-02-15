import java.util.HashMap;
import java.util.Map;

//TC - O(n) -- precisely O(2n+m) n-> length of the input string, m -> length of order
//SC - O(n)
/*
 * Generate a frequency map of chars in given Input string.
 * Iterate over the chars of order string and add to result String as they occur in frequency map and keep removing from the freq map for the number of times they occur.
 * Append the remaining characters of input to result.
 */
class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){ //O(n)
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char ch: order.toCharArray()){  //O(m)
            if(map.containsKey(ch)){
                int n = map.get(ch);
                for(int i=1;i<=n;i++){
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for(char key: map.keySet()){ //O(n)
            int n = map.get(key);
            for(int i=1;i<=n;i++){
                sb.append(key);
            }
        }
        return sb.toString();
    }
}