// Time Complexity : O(m+n) where m, n are the lengths of two strings.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : Capture the frequencies of each character in String s in a hashmap. Loop over the order string's character and get the
// frequency. Now append the frequency count of characters to the result string. At the end append the left over chars in the hashmap tp
// the result string.

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<s.length(); i++){ //capture frequencies of characters in String s
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        for(int i = 0;i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                for(int j = 0;j<count;j++){
                    result.append(ch);//append the first ones to result
                }
                map.remove(ch);
            }

        }
        for(char c : map.keySet()){ //append the rest of chars in string s to the result
            int count = map.get(c);
            for(int j = 0;j<count;j++){
                result.append(c);
            }
        }
        return result.toString();
    }
}