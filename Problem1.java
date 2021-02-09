// https://leetcode.com/problems/custom-sort-string/
// Time complexity : O(T)
// Space complexity : O(1)

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder str = new StringBuilder();
        int freq[] = new int[26];
        for(char c : T.toCharArray()){
            freq[c-'a']++;
        }
        
        for(char c : S.toCharArray()){
            int f = freq[c-'a'];
            if(f > 0){
                while(f-- > 0){
                    str.append(c);
                }
                freq[c-'a'] = 0;
            }
        }
        for(int i = 0;i<26;i++){
            int f = freq[i];
            if(f > 0){
                while(f-- > 0){
                    str.append((char)(i+'a'));
                }
            }
        }
        return str.toString();
    }
}