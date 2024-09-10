// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Store count of all letters in Hashmap
// append order length in String builder
// append the rest of the elements in any order

class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character,Integer> map = new HashMap<>(); //O(1) -> 26 char
        StringBuilder sb = new StringBuilder(); //O(n)

        //O(n)
        for(int i=0;i<s.length();i++){ 
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);            
        }

        //O(1)
        for(int i=0;i<order.length();i++){
            int count = map.getOrDefault(order.charAt(i), 0);
            for(int j=0;j<count;j++)
                sb.append(order.charAt(i));
            map.remove(order.charAt(i)); //remove order char after mapping
        }

        //O(1)
        for(char c: map.keySet()){
            int count = map.getOrDefault(c,0);
            for(int j=0;j<count;j++)
                sb.append(c);
        }

        return sb.toString();
    }
}