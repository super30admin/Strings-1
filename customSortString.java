// Time Complexity: O(m+n)
// Space Complexity : O(26) for map and O(s.length) for stringbuilder
// Idea here is to count all the characters present in string s and store in map
// iterate through the order string and append into string those character
// which are present in s string times frequency.
// Here the order is maintained and any other character remaining is appended in the end
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> str = new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            str.put(s.charAt(i), str.getOrDefault(s.charAt(i), 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++) {
            if(str.containsKey(order.charAt(i))) {
                int count = str.get(order.charAt(i));
                while(count>0) {
                    sb.append(order.charAt(i));
                    count--;
                }
                str.remove(order.charAt(i));
            }
        }
        for(char key: str.keySet()) {
            int count = str.get(key);
            while(count>0) {
                sb.append(key);
                count--;
            }
        }
        return sb.toString();
    }
}