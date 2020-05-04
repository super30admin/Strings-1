// Time Complexity : O(n)
// Space Complexity : O(1), as the size of the array is constant

class Solution {
    public String customSortString(String S, String T) {
        
        if(S==null || T==null){
            return null;
        }
        
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T.length();i++){
            count[T.charAt(i)-'a']++;
        }
        
        for(int i=0; i<S.length();i++){
            int charCount = count[S.charAt(i)-'a'];
            count[S.charAt(i)-'a'] = 0;
            for(int j=0; j<charCount;j++){
                sb.append(S.charAt(i));
            }
        }
        
        
        for(int i=0; i<T.length();i++){
            if(count[T.charAt(i)-'a']!=0){
                sb.append(T.charAt(i));
            }
        }
        
        return sb.toString();
    }
}