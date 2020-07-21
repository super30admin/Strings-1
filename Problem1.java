//Time Complexity: O(S.length+T.length)
//Space Complexity: O(T.length)
class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        
        for(char c: T.toCharArray()) {
            count[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length();i++) {
            for(int j = 0; j < count[S.charAt(i) - 'a'];j++)
                sb.append(S.charAt(i));
            count[S.charAt(i) - 'a'] = 0;
        }
        
        for(char c = 'a' ; c <= 'z'; c++)
        {
            if(count[c-'a'] != 0) {
                for(int j = 0 ; j < count[c-'a'];j++)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
