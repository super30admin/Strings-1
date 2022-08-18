// Time Complexity : o(s.length) s = string
// Space Complexity : o(1) // used hash map but 26 letters so size can't be more than that
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            if(map.containsKey(c)){
                int count=map.get(c);
                map.remove(c);
                while(count>0){
                    sb.append(c);
                    count--;
                }
            }
        }
        
        for(Character key:map.keySet()){
            int count = map.get(key);
            while(count>0){
                sb.append(key);
                count--;
            }
        }
        return sb.toString();
        
    }
}