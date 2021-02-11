Topic: String-1
Problem Link: https://leetcode.com/problems/custom-sort-string/


// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Code:
class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        if(T.length()==0) return sb.toString();
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i=0;i<T.length();i++){
            char t=T.charAt(i);
            hmap.put(t,  hmap.getOrDefault(t,0)+1); 
        }
        
        for(int i=0;i<S.length();i++){
            char s=S.charAt(i);
            if(hmap.containsKey(s)){
                int count=hmap.get(s); 
                    while(count!=0){
                        sb.append(s);
                        count--;
                    }
                hmap.remove(s);
            }
        }
        for(char c:hmap.keySet()){
            int count=hmap.get(c); 
                    while(count!=0){
                        sb.append(c);
                        count--;
                    }
                //hmap.remove(c);
        }
        return sb.toString();
    }
}
