// O(S.length+ T.length) || O (T.length)
class Solution {
    public String customSortString(String S, String T) {
     
        int[] count = new int[26];
        for (char c: T.toCharArray())
       
            count[c - 'a']++;

    
        StringBuilder ans = new StringBuilder();

        // Write all characters that occur in S, in the order of S.
        for (char c: S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
         
            count[c - 'a'] = 0;
        }

        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }
}
