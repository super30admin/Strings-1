//Time = O(m+n)
//Space = O(1)

class Solution {
    public String customSortString(String order, String str) {
        // Create an array to store the count of each character in str
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        // Append the characters in order to the output string, in the order specified by order
        for (char c : order.toCharArray()) {
            int index = c - 'a';
            while (count[index] > 0) {
                sb.append(c);
                count[index]--;
            }
        }
        
        // Append the remaining characters in str to the output string
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (count[index] > 0) {
                sb.append(c);
                count[index]--;
            }
        }
        
        return sb.toString();
    }
}
