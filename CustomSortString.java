// Time Complexity : O(m) + O(n) where m is the length of string order and n is the length of string s
// Space Complexity : O(1) // Even though we are using a hashmap, consider we have all lower case we will still be storing only 26 char and we don't consider space occupied by string builder as we return as a output
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to iterate over the hashmap to fetch the remaining characters

/*
Approach: Use a hashmap to store string s with key as the character and value to store the occurance of that character. Then iterate over order and check if that char exists in the map append in the string that character k times where k is the occurance of that character and then remove from the map. Then iterate over the leftover characters in the map and append to the string
 */
class Solution {
    public String customSortString(String order, String s) {

        if(s == null || s.length() == 0){
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        for(int i =0; i<order.length(); i++){
            char c = order.charAt(i);

            if(map.containsKey(c)){
                int times = map.get(c);

                for(int j =0; j<times;j++){
                    sb.append(c);
                }

                map.remove(c);
            }
        }

        for(char key: map.keySet()){
            int times = map.get(key);

            for(int i =0; i<times; i++){
                sb.append(key);
            }
        }
        return sb.toString();
    }
}