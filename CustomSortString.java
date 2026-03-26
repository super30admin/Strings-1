// Time Complexity : O(m + n), where m,n are lengths of the order and s strings
// Space Complexity : O(1), given map can contain a maximum of 26 letters
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to understand the frequency of letters common to order and s first and append them first to the
result.To do that, we use a hash map to record the letters and their respective frequencies. Now, we iterate
through the order string and check the common/intersection characters and append to the result and later remove
them from the map.If any characters get left out in the map, it means they are not common to both the strings
and can appear in any order.So iterate through the map and append them at last.
 */
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(char ch : order.toCharArray()) {
            if(map.containsKey(ch)) {
                int frq = map.get(ch);
                for(int i = 0 ; i < frq ; i++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        if(map.size() != 0) {
            for(Character ch : map.keySet()) {
                int frq = map.get(ch);
                for(int i = 0 ; i < frq ; i++)
                    sb.append(ch);
            }
        }
        return sb.toString();
    }
}