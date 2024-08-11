// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<order.length();i++){
            map.put(order.charAt(i), 0);
        }
        for(int i = 0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),0);
            }
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<order.length();i++){
            int count = map.get(order.charAt(i));
            while(count>0){
                sb.append(order.charAt(i));
                count--;
            }
            map.put(order.charAt(i), 0);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int count = entry.getValue();
            while(count>0){
                sb.append(entry.getKey());
                count--;
            }
        }
        return sb.toString();
    }
}