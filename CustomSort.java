package s30.strings.s1;

import java.util.HashMap;
import java.util.Map;


//Algo: using HashMap => add the frequencies to map for each character.
//iterate through the order string and add to the result string based on the freq in map.

//TC : O(n) n is length of the original string.
//SC: O(1) as we will have utmost of 26 characters in hashMap
public class CustomSort {

    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap();

        StringBuilder res = new StringBuilder();


        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        for(int i=0 ; i < order.length(); i++){
            char ch = order.charAt(i);
            int count = map.getOrDefault(ch, 0);

            while(count > 0){
                res.append(ch);
                count--;
            }

            map.remove(ch);
        }

        for(Map.Entry<Character, Integer> element: map.entrySet()){

            int count = element.getValue();
            char ch = element.getKey();

            while(count > 0){
                res.append(ch);
                count--;
            }

        }

        return res.toString();
    }




    public static void main(String[] args) {

    }
}
