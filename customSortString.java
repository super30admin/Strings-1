// Time Complexity : O(m + n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No  

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int le = s.length();
        for(int i = 0; i < le; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        StringBuilder result = new StringBuilder(); //O(n)
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                while(cnt>0){
                    result.append(c);
                    cnt--;
                }
                map.remove(c);
            }
        }
        for(char key: map.keySet()){
            int cnt = map.get(key);
            while(cnt > 0){
                result.append(key);
                cnt--;
            }
        }
        return result.toString();
    }
}