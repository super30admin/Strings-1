class Solution {
    public String customSortString(String S, String T) {

        HashMap<Character, Integer> hp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (hp.containsKey(c)) {
                hp.put(c, hp.get(c) + 1);
            } else {
                hp.put(c, 1);
            }
        }

        for (int j = 0; j < S.length(); j++) {
            char ch = S.charAt(j);
            if (hp.containsKey(ch)) {
                int count = hp.get(ch);
                appendChar(sb, ch, count);
            }
            hp.remove(ch);
        }

        if (!hp.isEmpty()) {
            for (char ch : hp.keySet()) {
                int count = hp.get(ch);
                appendChar(sb, ch, count);
            }

        }

        return sb.toString();

    }

    private void appendChar(StringBuilder sb, char c, int n) {
        while (n != 0) {
            sb.append(c);
            n--;
        }
    }
}