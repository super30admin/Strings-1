// Time Complexity - O(m+n) m = length of S and n = length of T
// Space Complexity - O(1)
class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];

        for(char ch : T.toCharArray()){
            count[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : S.toCharArray()){
            int times = count[ch-'a'];
            while(times>0){
                sb.append(ch);
                times--;
            }
            count[ch-'a']=0;
        }

        for(int i=0; i< 26;i++){
            int times = count[i];
            while(times>0){
                sb.append((char)(i+'a'));
                times--;
            }
        }
        return sb.toString();
    }
}