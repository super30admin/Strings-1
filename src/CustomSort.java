// Time Complexity:  O(max(n,m))
// Space Complexity: O(1)
// where n is number of letters in string s, m is number of letters in string order

import java.util.HashMap;
import java.util.Map;

class CustomSort {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder output = new StringBuilder();
        for(int i=0; i<s.length(); i++) {                                           // creating frequency map of string s
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0; i<order.length(); i++) {                                       // taking characters from string s as per string order
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                while(count > 0) {
                    output.append(c);
                    count--;
                }
// ******************** ANOTHER METHOD ********************
//                while(map.get(c) > 0) {
//                    output.append(c);
//                    map.put(c,map.get(c)-1);
//                }
                map.remove(c);                                                      // removing it from map if done
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {                 // taking remaining characters from string s
            int count = entry.getValue();
            while(count > 0) {
                output.append(entry.getKey());
                count--;
            }
        }
        return output.toString();
    }
}

//// ****************************** ANOTHER METHOD ******************************
//// Time Complexity:  O(n * long(n))
//// Space Complexity: O(1)
//// where n is number of letters in string s
//
//class Solution {
//    public String customSortString(String order, String s) {
//
//        Map<Character, Integer> map = new HashMap<>();
//        for(int i=0; i<order.length(); i++) {                                     // creating map maintaining order of characters from string order
//            map.put(order.charAt(i), i+1);
//        }
//
//        List<Character> list = new ArrayList<>();
//        for(int i=0; i<s.length(); i++) {                                         // creating list of characters from string s
//            list.add(s.charAt(i));
//        }
//
//        Collections.sort(list, (a,b) -> {                                         // custom sorting the list as per string order
//            return map.getOrDefault(a,0) - map.getOrDefault(b,0);
//        });
//
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<list.size(); i++) {
//            sb.append(list.get(i));
//        }
//        return sb.toString();
//
//    }
//}