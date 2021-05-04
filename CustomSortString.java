/**Leetcode Question 791 - Custom Sort String */
/**Algorithm
 * Create a hashmap of the longer string i.e String T
 * Iterate over the String S and check if the string T has the element.
 * If yes, take its count and put it in the stringbuilder
 * After the string S is completed iterated add all the leftover elements of String T at the end of the stringbuilder.
 */
/**TC - O(M+N) - M = Length of String S, N = Length of String T
 * SC - O(N)
 */
public class CustomSortString {
    class Solution {
        public String customSortString(String S, String T) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i =0; i<T.length();i++){
                char c = T.charAt(i);
                map.put(c, map.getOrDefault(c, 0) +1);
            }
            StringBuilder s = new StringBuilder();
            for(int i =0; i<S.length(); i++){
                char c = S.charAt(i);
                if(map.containsKey(c)){
                    int count = map.get(c);
                    while(count >0){
                        s.append(c);
                        count--;
                    }
                    map.remove(c);
                }
            }
            for(char c : map.keySet()){
                int count = map.get(c);
                while(count>0){
                    s.append(c);
                    count--;
                }
            }
            return s.toString();
        }
    }
}
