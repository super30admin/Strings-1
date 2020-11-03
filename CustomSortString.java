// Time Complexity : O(M + N)- M implies length of string S and N implies length of string T
// Space Complexity : O(N)- as we use a string builder which has all characters of String T of length N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public String customSortString(String S, String T) {
        if(S == "") return T;
        if(T == "") return T;
        StringBuilder sb = new StringBuilder();
        String s1 = "";
        int[] arr1 = new int[26];
        for(int i = 0;i < T.length();i++){
            arr1[T.charAt(i) - 'a']++;
        }
            
        for(int j = 0;j < S.length();j++){
            if(T.contains(String.valueOf(S.charAt(j)))){
                int k = S.charAt(j) - 'a';
                int count = arr1[k];
                while(count > 0){
                     sb.append(S.charAt(j));
                    count--;
                }
               
            }
        }
        for(int i = 0;i < T.length();i++){
            if(!sb.toString().contains(String.valueOf(T.charAt(i)))){
                 int k = T.charAt(i) - 'a';
                int count = arr1[k];
                while(count > 0){
                     sb.append(T.charAt(i));
                    count--;
                }
            }
        }
        return sb.toString();
    }
}
// Your code here along with comments explaining your approach