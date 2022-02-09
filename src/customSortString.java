import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
//    /*
//         // Time Complexity : O(n)
//         // Space Complexity : O(1)
//    */
public class customSortString {

    class Solution {
        public String customSortString(String order, String s) {
            // Map<Character, Integer> map = new HashMap<>();
            // //PUT into hashmap string s O(S)
            // for(int i=0; i<s.length(); i++) {
            //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            // }
            // StringBuilder str= new StringBuilder();
            // //tranverse orede and put in string O(order)
            // for(int i=0; i<order.length(); i++) {
            //     if(map.containsKey(order.charAt(i)) ){
            //         int o= map.get(order.charAt(i));
            //         while(o!=0) {
            //             str.append(order.charAt(i));
            //             o--;
            //         }
            //         map.remove(order.charAt(i));
            //     }
            // }
            // // put remaining string character back
            // //O(s)
            // for(Character c : map.keySet()){
            //     int o = map.get(c);
            //     while(o!=0) {
            //             str.append(c);
            //             o--;
            //         }
            // }

            Character[] tmpArr = new Character[s.length()];

            for (int i = 0; i < s.length(); i++) {
                tmpArr[i] = s.charAt(i);
                // System.out.println(tmpArr[i] );
            }


            Map<Character, Integer> map = new HashMap<>();
            //PUT into hashmap string s O(S)
            for(int i=0; i<order.length(); i++) {
                map.put(order.charAt(i), i);

            }
            Arrays.sort(tmpArr, new Comparator<Character>() {
                @Override
                public int compare(Character a, Character b) {
                    if(map.containsKey(a) && map.containsKey(b))
                        return (map.get(a) - map.get(b));
                    if(!map.containsKey(a))
                        if(!map.containsKey(b))
                            return a-b ;
                        else
                            return 1;
                    else
                        return -1;
                }
            });

            StringBuilder str= new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                str.append(tmpArr[i] );
            }
            return str.toString();
        }

    }
}
