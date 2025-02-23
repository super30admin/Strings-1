/*
Time Complexity: O(n + m) - Where n is the length of s and m is the length of order. We traverse s once to build the frequency map and iterate over order and remaining characters separately.
Space Complexity: O(n) - We use a HashMap to store character frequencies and a StringBuilder to construct the output.
*/

class Solution {
    public String customSortString(String order, String s) {
        //base
        if (order == null || order.length() == 0) {
            return s;
        }

        //logic
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        //creating a hashmap for string and the char freq
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int times = map.get(c);
                for(int j=0; j<times; j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for(char key: map.keySet()) {
            int times = map.get(key);
                for(int j=0; j<times; j++){
                    sb.append(key);
                }
        }

        return sb.toString();
    }
}