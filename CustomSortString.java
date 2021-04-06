class CustomSortString {

    // Time Complexity: O(nm)   (where n -> len(S) and m -> len(T))
    // Space Complexity: O(1)   (since t_arr --> would always be of length 26, also if output string does not count as extra space)

    public String customSortString(String S, String T) {
        // Edge Case Checking
        if(S == null || S.length() == 0 || T == null || T.length() == 0)
            return "";
        
        // Keep a character array for String T
        int[] t_arr = new int[26];
        StringBuilder sb = new StringBuilder();
        
        // Get the character counts for characters in String T
        for(char c : T.toCharArray()){
            t_arr[c - 'a']++;
        }
        
        // If that character occurs in String S --> then add to the final result string all occurrences of that character in String T
        for(char c : S.toCharArray()){
            while(t_arr[c - 'a'] > 0){
                sb.append(c);
                t_arr[c - 'a']--;
            }
        }
        
        // If there are remaining characters in String T --> add to the final result string
        for(char c: T.toCharArray()){
            if(t_arr[c - 'a'] > 0)
                sb.append(c);
        }
        
        // return the final result string
        return new String(sb);
    }
}