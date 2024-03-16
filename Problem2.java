import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;




// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Apr 1: We take a start pointer at 0. If the element at i is not in the set,
 * we put it in the set. Whenever we find a repeating element, we keep moving the
 * start pointer until we find the repeating character and keep on removing the element
 * at start simultaneously. At end, return the size of the set which will have the non-repeating
 * elements in the  window. We can also return i-start+1.
 *
 *
 *
 * Apr 2: We use a hashmap to store the chars and their indices. We keep on filling the map
 * until the char is not in the map. If it is in the map, and if the repeat is inside
 * the window (start -> i), we directly move the start pointer to the repeat's index + 1.
 * If not in the window, we do nothing. We never move backward. This will save extra
 * iterations in the apr 1 when escaping the repeat.
 */


public class Problem2 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int start = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(set.contains(c)) {
                while(s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(c);
            }

            max = Math.max(max, set.size());
        }

        return max;

    }


    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }

        return max;

    }
}
