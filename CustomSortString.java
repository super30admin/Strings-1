// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We go over string s and use a hashmap to store the mapping of character-> frequency
// We then go over order and if the char exists in map we append it to result
// Once we go over order, we can put the remaining map elements in the result in any order

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count>0){
                    res.append(c);
                    count--;
                }
            }
            map.remove(c);
        }
        for(Character key: map.keySet()){
            int count = map.get(key);
                while(count>0){
                    res.append(key);
                    count--;
                }
        }
        return res.toString();
    }
}