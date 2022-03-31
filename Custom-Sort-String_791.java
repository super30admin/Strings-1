
// Time Complexity : O(n) where n is length of string
// Space Complexity : O(1) since we are using int array of size 26
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Count the frequency of characters in s, and iterate over order and append all occurence of characters in s to a result and update frequency to 0
// At the end iterate over frquency array to append the remaining characters to result

class Solution {
    public String customSortString(String order, String s) {

        if (order == null || s == null || order.length() ==0) return s;

        int[] map = new int[26];
        for (char c : s.toCharArray()) {
              map[c-'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (map[c-'a'] > 0) {
                for (int i=0; i<map[c -'a'];i++) {
                    res.append(c);
                }
                map[c-'a'] = 0;;
            }
        }

       for (int i = 0; i < 26; i++) {
            for (int j=0; j<map[i];j++) {
                res.append((char)('a' + i));
        }
       }
        return res.toString();

    }
}
