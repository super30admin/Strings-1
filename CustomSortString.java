// Time Complexity : O(n) n is s.length()
// Space Complexity : O(1) as sb length wont count
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach: keep the count of each char in a array[26] 

public class CustomSortString {
    public static String customSortString(String order, String s) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        // sort chars by order of order
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }
        // group chars in s
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
