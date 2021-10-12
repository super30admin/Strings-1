// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

public class customSort{
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        
        for(char c: order.toCharArray()){
            for(int i = 0; i < freq[c - 'a']; ++i) {
                result.append(c);
                freq[c - 'a'] = 0;
            }
            
        }
        
        for(char c = 'a'; c <= 'z'; ++c)
            for(int i = 0; i < freq[c - 'a']; ++i)
                result.append(c);
        
        return result.toString();
    }
}