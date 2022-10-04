// Time complexity: O(s.length + order.length) = O(s.length) as order can be max of 26 chars so it is constant

// Space complexity: O(26) or O(1) as there are max of 26 keys in the hashmap

// Approach - count the number of occurences of each character in the string that needs to be sorted and add to hashmap. Take a string builder and iterate through the order string, check if it is in the hashmap and if it is, get the count (no. of occurences). Add that char to the string builder count number of times. After this loop we will have all the order characters in the string builder, now loop through all keys of the hashmap and add remaining characters to string builder and return

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar,0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char currentChar = order.charAt(i);
            if (map.containsKey(currentChar)) {
                int count = map.get(currentChar);
                for (int k = 0; k < count; k++) {
                    sb.append(currentChar);
                }
                map.remove(currentChar);
            }
        }
        
        for (Character key : map.keySet()) {
            int count = map.get(key);
            for (int i = 0; i < count; i++) {
                sb.append(key);
            }
        }
        
        return sb.toString();
    }
}