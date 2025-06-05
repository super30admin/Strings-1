// Time Complexity :O(m+n);
// Space Complexity :O(1);
public class customSortString {
    public String customSortString(String order, String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (char c : order.toCharArray()) {
        while (freq[c - 'a']-- > 0) {
            sb.append(c);
        }
    }
    for (char c = 'a'; c <= 'z'; c++) {
        while (freq[c - 'a']-- > 0) {
            sb.append(c);
        }
    }
    return sb.toString();
}

}
