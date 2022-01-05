package sol;
import java.util.*;

public class CustomSort {
public String customSortString(String order, String s) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for( int i=0;i<s.length();i++){
            
            char c= s.charAt(i);
            
            if(hm.containsKey(c)){
            
                hm.replace(c,hm.get(c)+1);
           
            }else{
                hm.put(c,1);
            }
          
            
        }
         // System.out.println(hm);
        
        StringBuilder ans=new StringBuilder();
        
        for(int i=0;i<order.length();i++){
            
            char c=order.charAt(i);
            while(hm.containsKey(c) && hm.get(c)!=0){
                
                ans=ans.append(c);
                hm.replace(c,hm.get(c)-1);
            }
            
        }
        
        for(char x :hm.keySet()){
            
           
                while(hm.get(x)!=0){
                
                    ans=ans.append(x);    
                    hm.replace(x,hm.get(x)-1);
                }
                
            
        }
        
        return ans.toString();
    }
}
