// Time Complexity : O(n) where n is the length of n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String order, String s) {
        //Hashmap to keep track of frequency of characters in s
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        //Go through characters of order and append the characters according to order and frequency in result
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            while(map.containsKey(c)){
                sb.append(c);
                int temp = map.get(c);
                temp--;
                if(temp == 0) map.remove(c);
                else map.put(c,temp);
            }
        }

        
        //Append the remaining characters that are in s but not in order
        for(char c: map.keySet()){
            int size = map.get(c);
            for(int i=0; i< size; i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}