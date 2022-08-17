// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0){
            return s;
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            int cnt = 0;
            if(hm.containsKey(c)){
                cnt = hm.get(c);
                hm.remove(c);
            }
            while(cnt>0){
                sb.append(c);
                cnt--;
            }
        }
        for(char key:hm.keySet()){
            int cnt = hm.get(key);
            while(cnt>0){
                sb.append(key);
                cnt--;
            }
        }
        return sb.toString();
    }
}