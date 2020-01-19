//Time Complexity: O(T.length + S.length)
//Space Complexity: (T.length) maximum = O(26)
//Leet code: Yes
//Any issue: No

class Solution {
    public String customSortString(String S, String T) {
        //base case
        if(S==null || T==null || S.length()==0 || T.length()==0){ return "";}
        //logic
        int[] array = new int[26];
        for(int m: array){ m = 0; } //initialization
        for(int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            array[c-'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        for(char c: S.toCharArray()){
            for(int i=0; i<array[c-'a']; i++)
                result.append(c);
            array[c-'a'] = 0; //reset to prevent repetition later
        }
        for(char c='a'; c<='z'; ++c){
            for(int i=0; i<array[c-'a']; i++){
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
