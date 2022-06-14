// Time: O((Order length * occurences of each character)+(given string length)+(remaining characters from the hashMap * No of occurences of each))
// Space: O(26) - constant
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        // collecting the occurences of each alphabet in the given string
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        StringBuilder res = new StringBuilder();
        // going over the order string
        // taking the counts collected from actual string for each character
        // putting same no of characters contingously to our result, in the same order as order string
        for(int k = 0;k<order.length();k++) {
            char character = order.charAt(k);
            if(map.containsKey(character)) {
                for(int i=0;i<map.get(character);i++){
                    res.append(character);
                }
            }
            map.remove(character);
        }
        // going over the other characters and adding it to the end of the result
        for(Character key: map.keySet()){
            for(int i=0;i<map.get(key);i++){
                res.append(key);
            }
        }
        return res.toString();
    }
}