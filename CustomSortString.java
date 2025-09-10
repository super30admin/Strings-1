// This solution uses a frequency map to store all the current occurences of the s to be permutated
// Then it iterates through the order and makes sure to append the elements by frequency with this order first
// Later we append the leftover character frequencies
class Solution {
    public String customSortString(String order, String s) {
        StringBuilder response = new StringBuilder("");
        Map<Character, Integer> frequencyMap = new HashMap();
        for(char c:s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }

        for(char c:order.toCharArray()) {
            for(int i=0;i<frequencyMap.getOrDefault(c, 0);i++) response.append(c);
            frequencyMap.remove(c);
        }

        for(Map.Entry<Character, Integer> entry:frequencyMap.entrySet()) {
            char c = entry.getKey();
            int val = entry.getValue();

            for(int i=0;i<val;i++) response.append(c);
        }
        return response.toString();
    }
}
