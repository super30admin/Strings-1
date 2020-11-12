class Solution {// Time of O(n) and space constant
    public void reverseWords(char[] s) {
     // Reversing the char arrays
     reverse(s, 0, s.length - 1);
     // Revering each words in array
     int start = 0;
     for (int i = 0; i < s.length; i++) {
         if (s[i] == ' ') {
             reverse(s, start, i - 1);
             start = i + 1;
         }
     }
     //  reverse the last word, if there is only one word this will solve the corner case
     // only be called when start < s.length for which the case is only single word
     reverse(s, start, s.length - 1);
 }
 
 public void reverse(char[] s, int start, int end) {
     while (start < end) {
         char temp = s[start];
         s[start++] = s[end];
         s[end--] = temp;
     }
 }
 }