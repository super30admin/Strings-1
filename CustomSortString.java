// Time complexity:- O(n*m)
// Space complexity:- O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences
/**
 * Approach:
 * This problem is about sorting the string 's' based on a custom order defined by the string 'order'.
 * I used two nested loops to iterate through each character in `order` and find its occurrences in 's', appending them to the result while marking processed characters.
 * After processing characters in the custom order, I appended the remaining characters from 's' that were not covered by 'order' to the result string.
 */ 
class Solution {
    public String customSortString(String order, String s) {

        StringBuilder st = new StringBuilder();
     
        char[] orderArray = order.toCharArray();
        char[] stringArray = s.toCharArray();

        // Iterate through each character in 'order' to sort 's' based on the custom order
        for(int i = 0; i < orderArray.length; i++ ) {
            char ch = orderArray[i];
            // Iterate through 's' to find all occurrences of the current character from 'order'
            for(int j = 0; j < stringArray.length; j++) {
                char sChar = stringArray[j];
                 // If the character matches, append it to the result and mark it as processed
                if (ch == sChar) {
                    // Append the character to the result and replace it with '*' to mark it as processed
                    while(ch == sChar){
                        st.append(ch);
                        stringArray[j] = '*'; // Mark the character as used
                        j++;
                        // Break if we've reached the end of the string
                        if (j >= stringArray.length){
                            break;
                        }
                        sChar = stringArray[j];                            
                   }    
                }                   
            }                   
        }
        // Append any remaining characters from 's' that were not covered by the custom order
        for (int j = 0; j < stringArray.length; j++) {
            if (stringArray[j] != '*') {
                st.append(stringArray[j]);
            }
        }
        // Convert the StringBuilder to a string and return the result
        String str = st.toString();
        return str;
    }
}