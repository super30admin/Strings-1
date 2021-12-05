// Time Complexity : O(N)max of length of s,order
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        StringBuilder st=new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            if(map.containsKey(c)){
                int count=map.get(c);
                while(count>0){
                    st.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(char c:map.keySet()){
             int count=map.get(c);
                while(count>0){
                    st.append(c);
                    count--;
                }
        }
        
        return st.toString();
    }
}