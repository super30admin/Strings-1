/*
* Approach:
*  1. Count the frequencies in String s and store in hashmap
* 
*  2. Iterate over characters in order, get the characters and search in hashmap.
        append the characters based on frequency to stringbuilder.
* 
*  3. After iterating characters in order, 
        iterate over leftover keys and append at last based on frequency.
        (any permutation)
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m+26)
    m = len of string s
* 
* Space Complexity: O(26) === O(1)
    use of hashmap but limited size
* 
*/

import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder str = new StringBuilder();

        for (char ch : order.toCharArray()) {
            if (hmap.containsKey(ch)) {
                int freq = hmap.get(ch);

                for (int index = 0; index < freq; index++) {
                    str.append(ch);
                }

                hmap.remove(ch);
            }
        }

        for (char key : hmap.keySet()) {
            int freq = hmap.get(key);

            for (int index = 0; index < freq; index++) {
                str.append(key);
            }
        }

        return str.toString();
    }
}
