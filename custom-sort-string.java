//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        //iterate over string and put character as key and frequencies as value
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //iterate over the order string
        //append the character in order the number of times it has occured.
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                while(count > 0) {
                    result.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        //append the remaining characters
        for(char c: map.keySet()) {
            int count = map.get(c);
                while(count > 0) {
                    result.append(c);
                    count--;
                }
        }
        return result.toString();
    }
}