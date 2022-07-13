// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    public static String customSortString(String order, String s) {
        int[] sMap = new int[26];
        // add values in sMap
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sMap[c - 'a']++;
        }
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        // traverse through ordermap and find occurence of this character in s and
        // then make a string builder and add this element into it.
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            while (sMap[c - 'a'] != 0) {
                sb.append(c);
                sMap[c - 'a']--;
            }
        }
        // add remaining characters
        for (int i = 0; i < 26; i++) {
            while (sMap[i] != 0) {
                sb.append((char) (i + 'a'));
                sMap[i]--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaaaabccccbbbbdaa";
        String order = "cba";
        System.out.println(customSortString(order, s));
    }
}