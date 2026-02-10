/*
problem - 791. Custom Sort String
Approach - First we count how many times each character appears in s using a map.
Then we add characters from order into the result in their given order and required frequency.
Finally, we add any leftover characters from s that weren’t in order.
Time Complexity - O(n+m) where n is length of s and m is length of order.
Space Complexity - O(1) // map has constant alphabet size entries
 */


import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        //HashMap to store the character of string and their count
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        // we add characters from order into the result in their given order and required frequency.
        for(char c : order.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int k = 0; k < count; k++){
                    sb.append(c);
                }
            }
            map.remove(c);
        }
        // we add any leftover characters from s that weren’t in order.
    for(char c : map.keySet()){
       int count = map.get(c);
       for(int k = 0; k < count; k++){
           sb.append(c);
       }
    }
    return sb.toString();
    }
}
