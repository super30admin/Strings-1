// Time Complexity : O(n) where n is number of characters of string s
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use hash map to store the occurence of each character in string s
// For each character in order we check if it is present in map if yes we append as many times in the order given in order string
//If there are any remaining characters still present in map we then append it to the result string

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //put characters  of string s and thier freq in map
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //iterate over the order string to and check for its existence in map 
        for(char c: order.toCharArray()) {
            if(map.containsKey(c)) {
                int cnt = map.get(c);
                for(int k = 0; k < cnt; k++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        //check for the remaining chars in string s
        for(char c: map.keySet()) {
            int cnt = map.get(c);
            for(int k = 0; k < cnt; k++) {
                sb.append(c);
            }
        }

        return sb.toString();
        
    }
}
