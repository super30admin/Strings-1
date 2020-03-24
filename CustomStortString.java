// Time Complexity : O(T + S). T & S are size of both strings respectively.
// Space Complexity : O(1) Frequency array or hashmap this is constand space of 26char.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Approach
//Problem statement -  Characters order in S has to be maintained in T if there is any other char other than what is available in S then that can be added at end or beginning.

// Solution - In string T get the number of char in hasmap(frequency map ) or frequency array
// Go over string s and pull all those char from Freqency array and append to the result for count number of times then reset those visited char to 0
// Go over the frequency array again and chec if there is any non-zero char. If so add them to result string as well.

class Solution {
    public String customSortString(String S, String T) {
        
        if(S == null || T== null)
            return "";
        
        int[] frequency = new int[26];
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i<T.length(); i++){
            int index = T.charAt(i) - 'a';   //get the index position from char 
            frequency[index] = frequency[index]+ 1;  // increment the counter for all the char
        }
        
        for(int i=0; i<S.length();i++){
            int index = S.charAt(i) - 'a'; //get the index position from char 
            int count = frequency[index];  // get the count from freq array
            if(count >0){ 
                writeToStringBuffer(sb, count, S.charAt(i));    
                frequency[index] = 0;
            }
        }
        
        for(int i=0; i<26; i++){
            if(frequency[i] >0){ // go over the frequency array and check if there is any remaining char with count value greater than 0
                writeToStringBuffer(sb, frequency[i], (char)(i + 'a'));    
            }
        }
        return sb.toString();
    }
    
    private void writeToStringBuffer(StringBuffer sb, int count, char c){
        while(count >0){
            sb.append(c);
            count--;
        }
    }
}
