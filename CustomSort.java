// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We use Hashmap to solve this
// we put the characters and their frequency in the string s in the hashmap
// Then we iterate over the string order and for each character we check the frequency and then append the character those many no.of times to the result
// after the iteration is done we check if they are any remaining characters and if yes add them to the result

class Solution {
    public String customSortString(String order, String s) {
        if (s == null || s.length() == 0)
            return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int times = map.get(c);
                for (int j = 0; j < times; j++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for (Character c : map.keySet()) {
            int times = map.get(c);
            for (int i = 0; i < times; i++)
                sb.append(c);
        }
        return sb.toString();

    }
}