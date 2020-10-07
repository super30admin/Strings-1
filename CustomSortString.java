// Time Complexity : O(N + M) wher N is the length of S and M is the length of T.
// Space Complexity : O(1) as we are only storing counts of 26 small alphabets which is constant.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class CustomSortString {
    public String customSortString(String S, String T) {
        
        int[] counts = new int[26];
        StringBuilder output = new StringBuilder();
        
        for(Character c : T.toCharArray()) {
            counts[c - 'a'] += 1;
        }
        
        for(Character c : S.toCharArray()) {
                while(counts[c - 'a'] > 0) {
                    output.append(c);
                    counts[c - 'a'] -= 1;
                }
        }
        
        for(int i = 0; i < counts.length; i++) {
            while(counts[i] > 0) {
                    output.append((char)('a' + i));
                    counts[i] -= 1;
            }
        }
        
        return output.toString();
    }
}