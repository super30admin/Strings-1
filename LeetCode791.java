// Time Complexity : O(s.length +t .length)
// Space Complexity : O(1) --> max is 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0 ; i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);   // add the characters and frequency
        }
        StringBuilder result = new StringBuilder();
        for(int i =0 ; i<order.length();i++) // to get the order iterate through order string
        {
            if(map.containsKey(order.charAt(i))){
                int count = map.get(order.charAt(i));  // get the count
                map.remove(order.charAt(i)); // remove from the map
                for(int k=0; k<count;k++){  // add the current char for its repeated no.of times
                    result.append(order.charAt(i));
                }
            }
        }

        for(Character ch :map.keySet()){  // add remaining characters from string s other than order string
            int count = map.get(ch);
            for(int k=0; k<count;k++){
                    result.append(ch);
                }
        }
        return result.toString();
    }
}