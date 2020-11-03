// Time Complexity: O(N)
// Space Complexity: O(N)
// Passed Leetcode

class Solution {
    public int lengthOfLongestSubstring(String S) {
        
        if (S.length() == 0 ) {
            return 0;
        }
        Set<String> hash_Set = new HashSet<String>();         
        
        int max_length = 0;
        int start = 0;
        int i;
        for (i = 0; i < S.length(); i++) {
            String value = String.valueOf(S.charAt(i));
            
            if (hash_Set.contains(value)) {
                
                max_length = Math.max(hash_Set.size(), max_length);
                
                int curr = start;
                while (hash_Set.contains(value)) {
                    hash_Set.remove(String.valueOf(S.charAt(curr)));
                    curr++;
                }
                start = curr;
                
            }
            hash_Set.add(value);
            
        }
        
        return Math.max(max_length, i - start);
    }
}