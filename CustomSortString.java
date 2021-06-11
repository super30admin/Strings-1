// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We save the count for each character in an array. Further, we append all the characters in a String in the order of the order String.
*/

class Solution {
    public String customSortString(String order, String str) {
        
        int[] arr = new int[26];
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i) - 'a'] ++;
        }
        
        String ans  ="";
        for(int i=0;i<order.length();i++){
            int ch = (int) (order.charAt(i) - 'a');
            while(arr[ch] > 0){
                char c = (char)(ch + 'a');
                ans+= c;
                arr[ch]--;
            }
        }
        
        for(int i=0;i<26;i++){
            while(arr[i] != 0){
                char c = (char)(i + 'a');
                ans+=c;
                arr[i]--;
            }
        }
        return ans;
    }
}