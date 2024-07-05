// Time Complexity : O(m+n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * 791. Custom Sort String
 * 
 * The problem states that we have to make our string such that its in the given order string
 * 
 * go through the array and count the number of characters of the string s and put them in map
 * 
 * now go through each character of order string and keep appending to the result 
 * 
 * dont forget to add the remaining characters left in the string s back at the end.
 */

import java.util.*;

public class CustomSortString {

    public String customSortString(String order, String s) {
        Map<Character, Integer> cache = new HashMap<>();

        for (char c : s.toCharArray()) {
            cache.put(c, cache.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (cache.containsKey(c)) {
                int size = cache.get(c);
                for (int i = 0; i < size; i++) {
                    result.append(c);
                }
                cache.remove(c);
            }
        }

        for (char c : cache.keySet()) {
            int size = cache.get(c);
            for (int i = 0; i < size; i++) {
                result.append(c);
            }
            // cache.remove(c); - cannot do this, be aware of concurrent modification
            // error., we are accessing cache so its locked for any modifications
        }

        return result.toString();
    }
}
