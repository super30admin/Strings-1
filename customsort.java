// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: store all the characters and the number of times they are repeated in an hashmap and then each letter in the order print all of them  then remove the key from map and print the remaining ons

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c , 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int k = 0 ; k < cnt; k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char c: map.keySet()){
            int cnt = map.get(c);
            for(int k = 0; k < cnt; k++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}