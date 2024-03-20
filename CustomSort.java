
// Time Complexity : O(s), length of s because order can have at max 25 characters
// Space Complexity : O(s), for the string builder.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : using frequency map create a string in the order of the "order" string.

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map  = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for(char c : order.toCharArray()){
            if(map.containsKey(c)){
                int cnt = map.get(c); // get the frequency of the character
                for(int k = 0 ; k < cnt ; k++){
                    result.append(c);
                }

                map.remove(c);
            }
        }

        //Remaining character
        for(Character c : map.keySet()){
            int cnt = map.get(c); // get the frequency of the character
            for(int k = 0 ; k < cnt ; k++){
                result.append(c);
            }
        }

        return result.toString();
    }
}