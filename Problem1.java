class Solution {
    public String customSortString(String order, String s) {
        if (order == null || order.length() == 0) return s;

        int[] freq = new int[26];

        StringBuilder sb = new StringBuilder(s);
        StringBuilder result = new StringBuilder();

        Set<Character> charSet = new HashSet<>();
        for (int i=0; i<order.length(); i++) {
            charSet.add(order.charAt(i));
        }

        int l = s.length(); 

        for (int i=0; i<l; i++) {

            char c = sb.charAt(i);
            if (charSet.contains(c)) {
                freq[c-'a']++;
            } else {
                result.append(c);
            }

        }

        for (int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            for (int j=0; j<freq[c - 'a']; j++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
