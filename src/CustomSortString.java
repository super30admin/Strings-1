import java.util.HashMap;

/**
 * 
 */

/**
 * @author Aditya Sinha
 * Frequency of each character of S stored in HashMap
 * Iterate over order string and if its in hashmap, append it to result string how many times its frequency
 * then remove from map
 * do same for remaining characters then
 * Time Complexity - O(m + n)
 * Space Complexity - O(1)
 */
public class CustomSortString {

	public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        StringBuilder sb = new StringBuilder();

        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int cnt = map.get(c); // get occurrence count
                for(int k=0; k<cnt; k++){ // iterate till number of frequency
                    sb.append(c); // append in the result string
                }
                map.remove(c); // remove once added in result string
            }
        }

        for(char c : map.keySet()){ // for remaining characters
            int cnt = map.get(c);
            for(int k=0; k<cnt; k++){ // same iterate till frequency
                sb.append(c); // append later
            }
        }

        return sb.toString();
    }
}
