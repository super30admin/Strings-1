//Time Complexity O(m*n)
//Space Complexity O(1) array of 26  
//leetcode tested

public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for(char c: order.toCharArray()){
            while(freq[c - 'a'] > 0){
                ans.append(c);
                freq[c - 'a']--;
            }
        }

        for(int i=0;i < 26;i++){
            int freqC = freq[i];
            while(freqC>0){
                ans.append((char)(i + 'a'));
                freqC--;
            }
        }
        return ans.toString();
    }

}
