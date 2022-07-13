// Time Complexity : O(N)
// Space Complexity : O(N) (we are using StringBuilder of size N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String order, String s) {

        // Create Frequency Array
        int[] frequency = new int[26];

        // fill it with String s chars
        for (char c : s.toCharArray()) frequency[c - 'a']++;

        StringBuilder result = new StringBuilder();

        for (char c : order.toCharArray()) {

            if (frequency[c - 'a'] == 0) continue;

            while(frequency[c - 'a'] > 0) {
                result.append(c);
                frequency[c - 'a']--;
            }

        }

        // collect other chars
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == 0) continue;

            int count = frequency[i];
            while (count > 0) {
                result.append((char)(i + 97));
                count--;
            }
        }

        return result.toString();
    }
}