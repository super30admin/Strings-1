# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No






class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] frequency = new int[26];

        for(char ch: T.toCharArray()){
            int index = ch - 'a';
            frequency[index]++;
         }

        for(char ch: S.toCharArray()){
            int index = ch - 'a';
            int count = frequency[index];
            writeChar(sb, ch, count);
            frequency[index] = 0;

         }


        for(int i = 0; i < 26; i++){
            char ch = (char)('a' + i);
            writeChar(sb, ch, frequency[i]);
            frequency[i] = 0;

        }
        return sb.toString();

    }


    private void writeChar(StringBuilder sb, char ch, int n){
        while(n > 0){

            sb.append(ch);
            n--;
        }
    }
}