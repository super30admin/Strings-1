// Time Complexity : n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    StringBuilder sb = new StringBuilder();
    public String customSortString(String S, String T) {
        if(S==null || S.length()==0 || T==null || T.length()==0) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<T.length();i++){
            if(map.containsKey(T.charAt(i))){
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            }
            else{
                map.put(T.charAt(i),1);
            }
        }
        
        for(int i=0;i<S.length();i++){
           if(map.containsKey(S.charAt(i))){
               StringMultiplier(sb,S.charAt(i),map.get(S.charAt(i)));
               map.remove(S.charAt(i));
           } 
            
        }
        for(Map.Entry element: map.entrySet()){
            // sb.append(element.getKey());
            char ch = element.getKey().toString().charAt(0);
            int val = (Integer)element.getValue();
            StringMultiplier(sb,ch,val);
            
        }
        
        return sb.toString();
    }
    
    public void StringMultiplier(StringBuilder sb, char tmp, int val){
        
        while(val>0){
         sb.append(tmp);
         val--;   
        }
    }
}