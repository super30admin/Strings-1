/* 791. Custom Sort String
https://leetcode.com/problems/custom-sort-string/

// TC: O(t) + O(s)
// SC: O(unique chars in T)
// Approach: Count the number of occurences for every character in T.
// Traverse S, and for those characters in S that occur in T, append character to result string, 'num_of_occurence' times.
// Traverse count of T and add remaining characters, these are the ones that occur in T but not in S.
*/

class CustomSortString {
    public static String customSortString(String S, String T) {
        if (S == null || S.length() == 0) {
            return T;
        }
        
        int[] countT = new int[26];
        
        for (char c: T.toCharArray()) {
            countT[c - 'a']++;
        }
        
        StringBuffer res = new StringBuffer();
        
        for (char c: S.toCharArray()) {
            while (countT[c - 'a'] > 0) {
                countT[c - 'a']--;
                res.append(c);
            }
        }
        
        for (int i = 0; i < countT.length; i++) {
            while (countT[i] > 0) {
                res.append((char)('a' + i));
                countT[i]--;
            }
        }
        
        return res.toString();
    }

    public static void main(String args[]) {
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("cbad", "abc"));
    }
}