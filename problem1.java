class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String output = "";

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (map.containsKey(ch)) {
                int c = map.get(ch);

                while (c > 0) {
                    output += ch;
                    c--;
                }

                map.remove(ch);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int c = entry.getValue();

            while (c > 0) {
                output += ch;
                c--;
            }
        }

        return output;
    }
}