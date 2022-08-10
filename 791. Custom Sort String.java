// Time Complexity: O(m + n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

// Your code here along with comments explaining your approach: Create HashMap of the characters, then according to priority put priority characters first * no. of occurence then add rest of characters after the priority characters

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            int cnt = 0;
            if(map.containsKey(c)){
                cnt = map.get(c);
                map.remove(c);
            }
            while(cnt > 0){
                sb.append(c);
                cnt--;
            }
        }
        for(char key : map.keySet()){
                int cnt = map.get(key);
                while(cnt > 0){
                    sb.append(key);
                    cnt--;
                }
            }
        return sb.toString();
    }
}