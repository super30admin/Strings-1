// Time Complexity : O(m+n)= O(n) where 'n' is the length of the string.
// Space Complexity : O(n) for hashmap but since hasmap contains all the lowercase characters so we can consider O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/custom-sort-string/
// Any problem you faced while coding this : No


class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        StringBuilder result = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int k=0;k<count;k++){
                    result.append(c);
                }
                 map.remove(c);
            }
        }
        for(char c:map.keySet()){
           int count = map.get(c);
                for(int k=0;k<count;k++){
                    result.append(c);
                }
        }

        return result.toString();

    }
}
