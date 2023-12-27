/*
Solution with HashSet
Take left pointer at 0, right at 1; 
keep moving pointers, until found occurence exist in Hashset. 
tc: O(n) - 2 pass
sc: O(1)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // base case
        if (s == null || s.length() == 0)
            return 0;

        Set<Character> set = new HashSet<>();

        int left = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (c != s.charAt(left)) {
                    set.remove(s.charAt(left++));
                }
                left++;
            }
            set.add(c);
            result = Math.max(result, i - left + 1);
        }

        return result;
    }
}

// approach -2 with HashMap of charatcers and Integers as index , saving a while
// loop traversing over left pointer, to just jum to the right index

/*
 * Solution with HashSet
 * Take left pointer at 0, right at 1;
 * move left poineters to index+1,
 * tc: O(n) - 1 pass
 * sc: O(1)
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // base case
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, i);
            result = Math.max(result, i - left + 1);
        }

        return result;
    }
}