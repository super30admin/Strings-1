class CustomSort {

    /**
     * Time Complexity: O(N) N is max of length of S or T
     * Space Complexity: O(1)
     * 
     * Approach:
     * 1. we can take an array of integers representing the 26 letters and maintain the count of characters 
     * of string T.
     * 2. For every character in string S, we can decrease the count of characters in array and at the same time
     * add in stringbuilder which will maintain the characters sorted.
     * 3. once all characters from S are added, we can added rest in the stringbuilder.
     */

    public String customSortString(String S, String T) {
        
        if(S == null || S.length() == 0)
            return T;
        
        int[] count = new int[26];
        StringBuilder result = new StringBuilder();
        
        for(char c : T.toCharArray()) {
            count[c - 'a']++;
        }
        
        for(char c : S.toCharArray()) {
            while(count[c - 'a'] > 0) {
                result.append(c);
                count[c - 'a']--;
            }
        }
        
        for(char c : T.toCharArray()) {
            while(count[c - 'a'] > 0) {
                result.append(c);
                count[c - 'a']--;
            }
        }
        
        return result.toString();
        
    }
}