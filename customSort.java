/*
Passed All Test Cases 

Big O
Time-> O(N + M), N is # of char in S and M is # of chars in T
Space-> O(1)

*/

class Solution {
    public String customSortString(String S, String T) {
        
        //tracking frequencies of char(s) in T 
        int [] cf = new int[26] ; 
        
        for (int i = 0 ; i < T.length() ; i++) {
            char add = T.charAt(i) ; 
            cf[add - 'a']++ ; 
        }
        
        StringBuilder ans = new StringBuilder() ; 
        
        for (int i = 0 ; i < S.length() ; i++) {
            char check = S.charAt(i) ; 
            
            while(cf[check - 'a'] > 0) {
                ans.append(check) ;
                cf[check - 'a']-- ; 
            }
        }
        
        //adding the remaining characters
        
        for (int i = 0 ; i < 26 ; i++) {
            while(cf[i] > 0) {
                ans.append((char)(i + 'a')) ;
                cf[i]-- ; 
            }
        }
        
        return ans.toString() ; 
        
    }
}