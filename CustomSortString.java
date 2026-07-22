/**
 * Time Complexity:  O(n + m) where n is length of s and m is length of order.
 * Space Complexity: O(1) (since the map has at most 26 entries, constant-size alphabet).
 */

class Solution {
    public String customSortString(String order, String s) {

        StringBuilder tempResult = new StringBuilder();
        Map<Character, Integer> frequencyInS = new HashMap<>();


        for (char ch : s.toCharArray()) {
            frequencyInS.put(ch, frequencyInS.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < order.length(); i++) {
            if (frequencyInS.containsKey(order.charAt(i))) {
                int numOfTimesInS = frequencyInS.get(order.charAt(i));
                for (int j = 0; j < numOfTimesInS; j++) {
                    tempResult.append(order.charAt(i));
                }
                frequencyInS.remove(order.charAt(i));

            }
        }

        for (char ch : frequencyInS.keySet()) {
            for (int j = 0; j < frequencyInS.get(ch); j++) {
                tempResult.append(ch);
            }

        }

        return tempResult.toString();

    }
}