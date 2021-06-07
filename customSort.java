// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
import java.util.*;

public class customSort {
    
    public String customSortString(String order, String str) {
        
        StringBuilder sb=new StringBuilder();
        if(str==null || str.length()==0)
            return sb.toString();
        
        HashMap<Character, Integer> sMap=new HashMap<>();
        
        for(int i=0;i<str.length();i++){
            char c =str.charAt(i);
            sMap.put(c, sMap.getOrDefault(c,0)+1);
        }
        
         for(int i=0;i<order.length();i++){
            char c =order.charAt(i);
            if(sMap.containsKey(c)){
                int count=sMap.get(c);
                while(count!=0){
                    sb.append(c);
                    count--;
                }
                sMap.remove(c);
            } 
        }
        
        for( char c : sMap.keySet()){
            int count=sMap.get(c);
            while(count!=0){
                sb.append(c);
                count--;
            }
        }
        
        return sb.toString();
    }
}
