// Time Complexity : O(S+T) as we are iterating over the whole length of both the strings
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I still feel this is a difficult problem. Even after class.


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
 
        
        //append result here
        StringBuilder sb = new StringBuilder();
        
        //array to store the frequency count of characters from T
        int[] freq = new int[26];
        
        //populate with integer to char mapping
        for(char ch: T.toCharArray()){
            int index = ch - 'a';
            System.out.println(ch + " " + index);
            freq[index]++;
        }
        
        //custom order
        for(char ch: S.toCharArray()){
           int index = ch - 'a';
           int count = freq[index];
            System.out.println("count: " + ch + " " + count);
            writeChar(sb, ch, count);
            freq[index] = 0;
        }
        
        //append remaining characters from T
        for(int i=0; i<26; i++){
            char ch = (char) ('a' + i);
            writeChar(sb, ch, freq[i]);
            freq[i] = 0;
        }
        
        return sb.toString();
    }
    
    private void writeChar(StringBuilder sb, char ch, int n){
        while(n>0){
            sb.append(ch);
            n--;
        }
    }
}