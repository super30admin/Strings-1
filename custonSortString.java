// Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

// Time Complexity : O(n)
// Space Complexity : O(1) - constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take a hashmap to store the occurances of chars and frequencies of s and iterate over order and if char is found append char count times.
 * If there are any chars still left appends them to the stringbuilder and finally stringbuilder.toString().
 */
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }
            else{
                map.put(ch, map.get(ch)+1);
            }
        }

        for(int i = 0; i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                while(count>0){
                    sb.append(ch);
                    count--;
                }
                map.remove(ch);
            }
        }

        for(Character ch: map.keySet()){
            int count = map.get(ch);
            while(count>0){
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();
    }
}