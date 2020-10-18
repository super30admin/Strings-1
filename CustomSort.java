// Time Complexity : O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String S, String T) {
        
        Map<Character,Integer> hashmap = new HashMap<>();
        
        String op ="";
        
        for(int i=0;i<T.length();i++){
            char ch = T.charAt(i);
            if(hashmap.containsKey(ch)){
                hashmap.put(ch, hashmap.get(ch)+1);
            }else{
                hashmap.put(ch, 1);
            }
            
        }
        
        for(int i=0;i<S.length();i++)
        {
            char ch = S.charAt(i);
            if(hashmap.containsKey(ch)){
                int count = hashmap.get(ch);
                while(count>0){
                    op+=ch;
                    count--;
                }
            }
            hashmap.remove(ch);
        } 
        
        for(Map.Entry<Character,Integer> entry: hashmap.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();
            while(count>0){
                op+=ch;
                count--;
            }  
        }
        
        return op;
    }
}