
/*
Time Complexity: (O(m + n)) where m, n are lenghts of S and T
Space Complexity : O(1) although we are using a frequency array of size 26 which is still constant

*/


// Did this code successfully run on Leetcode :

// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        //Define a StringBuffer for easier manipulation of final result
        StringBuffer sb = new StringBuffer();
        
        /*Define an int array, in which we can store the
        frequency of each char in T, we need this as we have to main the order 
        of characters according to String S. Next time when we iterate through
        S to find out if a char exists in T, it will be inorder
        */
        
        int [] frequency = new int [26];
        
        for(char c : T.toCharArray()){
            frequency[c - 'a']++ ;
        }
        
        /*Iterate through S, and find if any of elements in T are same.
        If same append to b that number of times and decrement the frequency
        */
        for(int i = 0; i < S.length(); i++){
            //This will give the index of frquency array to which we have to go
            int index = S.charAt(i) - 'a';
            
            /*If I take if condition, then 
            "kqep","pekeq" testcase fails as both ee's should be together
            */
            while(frequency[index] > 0){ 
                sb.append(S.charAt(i));
                frequency[index] -- ;
            }
        }
        
        //add the remaining elements of T to sb
        
        for(int x = 0; x < 26; x++){
            while(frequency[x] > 0){
                sb.append((char) (x + 97));
                frequency[x]--;
            }
                
        }
        
        return sb.toString();
        
        
    }
}