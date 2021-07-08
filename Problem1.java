class Solution {
    public String customSortString(String S, String T) {
        int [] arr = new int [26];
        //count T characters
        for(char ch: T.toCharArray()){
            arr[ch-'a']++;
        }
        System.out.print(arr);
        // append S  chars at the right order as many times as they appear in T
        StringBuilder sb = new StringBuilder();
        for(char ch: S.toCharArray()){
            while(arr[ch-'a']>0){
                sb.append(ch);
                arr[ch-'a']--;
            }
        }
        //append the rest of the T characters
        for(int i = 0; i<arr.length; i++){
            while(arr[i]>0){
                sb.append((char)(i+'a'));
                arr[i]--;
            }
        }
        
        return sb.toString();
    }
}
