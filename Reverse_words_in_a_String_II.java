class Solution {
    public void reverseWords(char[] s) {
        // Reverse entrie char array
        reverse(s, 0, s.length -1);
        int start = 0;
        int end;
        // Reverse each word that is separated by a space
        for(int i=0; i<s.length; i++){
            if(s[i]== ' ')
            {
                end = i-1;
                reverse(s, start, end);
                start = i+1; // Update start for next word
    
            }
            // If you've reached the last word
            if(i == s.length -1)
            {
                reverse(s, start, i);
            }
        }
    }
    
    private void reverse(char[] s, int start, int end){
        // Reverse by swapping start index and end index, then update those indices
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

// TC- O(N)
// SC- O(1) since reversal is done in-place
