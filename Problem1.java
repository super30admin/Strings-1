// Time Complexity : O(S + T)
// Space Complexity : O(T)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/custom-sort-string/

class Solution {
    public String customSortString(String S, String T) {

        int[] count = new int[26];
        for (char c: T.toCharArray())
            count[c - 'a']++;

        StringBuilder ans = new StringBuilder();

        for (char c: S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
            count[c - 'a'] = 0;
        }
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }
}
