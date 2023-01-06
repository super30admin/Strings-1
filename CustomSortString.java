// Time Complexity :O(m+n) n is the length of string s, m is the length of order string.
// But m=26 given in question , so O(26+n) ~= O(n)
// Space Complexity : O(26) ~= O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {

        //maintain a frequency map for the string s

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) +1);
        }

        StringBuilder sb = new StringBuilder();

        //iterate over order string and append value sto the sb result
        for(int k = 0 ; k < order.length() ; k++){
            char c = order.charAt(k);
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int j = 0 ; j < count ; j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        //iterate on the map keyset and append the remaining characters to sb result
        for(Character c: map.keySet()){
            int count = map.get(c);
            for(int j = 0 ; j < count ; j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}