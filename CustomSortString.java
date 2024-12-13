// Approach : Using HashMap store character frequencies of source.
// Time : O(n) + O(m) + O(26) = O(n+m)
// Space : O(1) // HashMap to store 26 letters
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // iterate through order and look up the character in Map
        // append the count of characters to the result and remove the character from the map
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int cnt = map.get(ch);
                for(int j=0;j<cnt;j++){
                    result.append(ch);
                }
                map.remove(ch);
            }
        }

        // Go through map and see the remianing characters and append to the result at
        // the end
        for(char ch:map.keySet()){
            int cnt = map.get(ch);
            if (cnt > 0) {
                for (int j = 0; j < cnt; j++) {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

        

}

