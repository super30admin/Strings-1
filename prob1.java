// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public String customSortString(String order, String s) {
        int freq[] = new int [26];
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < order.length(); i++) {
            while (freq[order.charAt(i) - 'a'] > 0) {
                result+= order.charAt(i);
                freq[order.charAt(i) - 'a']--;
            }
        }
        for (int i = 0;i < 26; i++) {
            while (freq[i] > 0) {
                result+= (char)(i + 'a');
                freq[i]--;
            }
        }
        return result;
    }
}