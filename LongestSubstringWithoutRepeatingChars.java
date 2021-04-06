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

// Optimized Sliding Window Solution: 

class LongestSubstringWithoutRepeatingChars {

    // Time Complexity: O(n)    (where n -> length of the string)
    // Space Complexity: O(n)

    public int lengthOfLongestSubstring(String s) {
        // Edge Case Checking
        if(s == null || s.length() == 0)
            return 0;
        
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        
        int start = 0;
        int end = 0;
        
        while(end < n){
            char c = s.charAt(end);
            // If we have already seen this character - get the index of that character and only update the start pointer to that position if its greater than the current start position
            if(map.containsKey(c))
                start = Math.max(start, map.get(c));
            // update the map with index position for each character everytime
            map.put(c, end+1);

            // Update the maxLen everytime
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}