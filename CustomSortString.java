// Time Complexity : O(m+n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Count Character Frequencies: The code counts how many times each character appears in the string `s` using a hashmap.
//Sort by `order` String: It then builds the output string by adding characters from `order` in their specified sequence, repeating them as per their count in the hashmap.
//Append Remaining Characters: Finally, it appends any characters from `s` that were not in `order` to the output string, maintaining their original counts.

class Solution {
    public String customSortString(String order, String s) {
        if(s == null || s.length()==0){
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0; i< order.length();i++){
            char c= order.charAt(i);
            if(map.containsKey(c)){
                int times = map.get(c);
                for(int j=0; j < times; j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char key:map.keySet()){
            int times = map.get(key);
            for(int j =0; j<times ;j++){
                sb.append(key);
            }
        }
        return sb.toString();
    }
}