// TC : O( n + m) n = len of order, m = len of s
// SC : O(n) because of StringBuilder
// Runs on LC: YES
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!freqMap.containsKey(ch)) {
                freqMap.put(ch, 0);
            }
            freqMap.put(ch, freqMap.get(ch) + 1);
        }

        for (int i = 0; i < order.length(); i++) {
            Character ch = order.charAt(i);

            if (!freqMap.containsKey(ch)) {
                continue;
            }

            for (int j = 0; j < freqMap.get(ch); j++) {
                sb.append(ch);
            }

            freqMap.remove(ch);
        }

        for (Character key : freqMap.keySet()) {
            for (int i = 0; i < freqMap.get(key); i++) {
                sb.append(key);
            }
        }

        return sb.toString();
    }
}