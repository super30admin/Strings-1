//https://leetcode.com/problems/custom-sort-string/
/*
Time: O(m+n) where m=S.length() & n=T.length() 
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class CustomSortString {
    public String customSortString(String S, String T) {

        // count[char] = the number of occurrences of 'char' in T.
        int[] count = new int[26];
        for (char c : T.toCharArray())
            count[c - 'a']++;

        StringBuilder ans = new StringBuilder();

        // Write all characters that occur in S, in the order of S.
        for (char c : S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            // Setting count[char] to zero to denote that we do
            // not need to write 'char' into our answer anymore.
            count[c - 'a'] = 0;
        }

        // Write all remaining characters that don't occur in S.
        // That information is specified by 'count'.
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();

    }

}
