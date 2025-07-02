// Time Complexity : O(n) where n is length of order (at max order can be of length 26)
//  Space Complexity : O(n) worst case where result string is same lenght as s
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
//1. We create a map to count the occurrences of each character in string s.
//2. We iterate through the characters in order, appending them to the result string based on their count in the map.
//3. Finally, we append any remaining characters from s that were not in order to the result string.


class Solution {
    public String customSortString(String order, String s) {
        // Create a StringBuilder to build the result string
        StringBuilder sb = new StringBuilder();
        // A Hashmap to count occurrences of each character in s
        Map<Character, Integer> sMap=new HashMap<>();
        // Iterate through each character in s and populate the map with counts
        for(char c: s.toCharArray()){
            if (!sMap.containsKey(c)){
                sMap.put(c,1);
            }
            else{
                sMap.put(c,sMap.get(c)+1);
            }
            
        }
        System.out.println(sMap);
        // Iterate through each character in order
        // and append the characters to the result string based on their count in sMap
        for(int i=0;i<order.length();i++){
            char ch=order.charAt(i);
            if (sMap.containsKey(ch)){
            int cnt=sMap.get(ch);
            for(int k=0;k<cnt;k++){
                sb.append(ch);
            }
            // Remove the character from the map after appending
            sMap.remove(ch);
            }
        }
        // Append any remaining characters from s that were not in order
        for (char ch : sMap.keySet()) {
            int cnt = sMap.get(ch);
            for (int k = 0; k < cnt; k++) {
                sb.append(ch);
            }
        }
        // Convert StringBuilder to String and return the result
        return sb.toString();
    }
}