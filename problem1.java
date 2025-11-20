// Time Complexity : O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
 * We are using HashMap to solve the problem
 * 
 * first make the hashmap of the "s" string, where key are the chars
 * and value is the number of oocurance of that number
 * 
 * when start anohter loop on the "order" string and itterate over all the chars in "order", is that char 
 * is in map start anohter for loop of add that all the occorances of the char to result and then remove that
 * char from string
 * 
 * finally to add all the other chars not given in the order take anohter loop and just add them to the result
 */

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (map.containsKey(ch)) {
                int cnt = map.get(ch);
                for (int k = 0; k < cnt; k++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for (char key : map.keySet()) {
            int cnt = map.get(key);
            for (int k = 0; k < cnt; k++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}