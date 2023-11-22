// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i = 0; i < order.length();i++){
            char ch = order.charAt(i);
            int count = map.getOrDefault(ch,0);
            while(count > 0){
                sb.append(ch);
                count--;
            }
            map.remove(ch);
        }
        for(char ch : map.keySet()){
            int count = map.get(ch);
            while(count > 0){
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();

    }
}