class LongestSubstringWithoutRepeatingChars {

    // Time Complexity: O(n)    (where n -> length of the string)
    // Space Complexity: O(1)   (since the integer array used is of length 128 -- therefore constant)

    public int lengthOfLongestSubstring(String s) {
        // Edge Case Checking
        if(s == null || s.length() == 0)
            return 0;
        
        int n = s.length();
        int[] arr = new int[128];
        int i = 0;
        int j = i+1;
        // Increment the first character count of the arr
        arr[s.charAt(i)]++;
        // Since we add the first character -- therefore result string is 1
        int result = 1;
        
        while(j < n){
            char c = s.charAt(j);
            // If we have not seen the character before -- then update the character count. Find the maximum length till here
            if(arr[c] == 0){
                arr[c]++;
                result = Math.max(result, j-i+1);
            }
            else{
                // Otherwise find the maximum length - since we see a character which has already encountered
                result = Math.max(result, j-i);
                // Till we don't find the encountered character -- increment the "i" pointer. Also decrement the character counts
                while(c != s.charAt(i)){
                    arr[s.charAt(i)]--;
                    i++;
                }
                i++;
            }
            j++;
        }
        
        return result;
    }
}