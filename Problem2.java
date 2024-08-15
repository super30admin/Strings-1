//Time = O(n), n is the length of input string
//Space = O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {  // Check if the input string is empty
            return 0;
        }
        int ans = 1;  // Initialize the length of the longest substring to 1
        int[] index = new int[128];  // Create an array to store the last seen index of each character in the substring
        Arrays.fill(index, -1);  // Initialize the array to -1
        
        int i = 0;  // Initialize the starting index of the substring
        for (int j = 0; j < n; j++) {  // Iterate over each character in the string
            char c = s.charAt(j);
            i = Math.max(i, index[c] + 1);  // Update the starting index of the substring based on the last seen index of character c
            ans = Math.max(ans, j - i + 1);  // Update the length of the longest substring
            index[c] = j;  // Update the last seen index of character c
        }
        
        return ans;  // Return the length of the longest substring
    }
}
