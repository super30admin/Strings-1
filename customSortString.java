// Time Complexity : O(k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public String customSortString(String order, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        StringBuilder sb = new StringBuilder(); // O(n)
        for(int i=0; i< order.length(); i++){
            char c =  order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                while(cnt > 0){
                    sb.append(c);
                    cnt--;
                    map.put(c, cnt);
                }
                // map.remove(c);
            }
        }
        // put remaining elements at the end of sb
        for(char key: map.keySet()){
            int cnt = map.get(key);
            while(cnt > 0){
                    sb.append(key);
                    cnt--;
            }
            // map.remove(key);
        }
        return sb.toString();
    }
}