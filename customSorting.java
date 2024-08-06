/*
TC --> O(n)
SC --> O(n) 
 */
class Solution {

    public String customSortString(String order, String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }//for
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (freq.containsKey(c)) {
                int count = freq.get(c);
                while (count > 0) {
                    st.append(c);
                    count--;
                }
            }
            freq.remove(c);
        }//for

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            while (val != 0) {
                st.append(key);
                val--;
            }//while
        }//for

        return st.toString();
    }
}
