/*
time complexity: O(n)
Space Complexity: O(n)
*/
import java.util.*;
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> a =new HashMap<>();
        for(int i=0;i<s.length();i++){
            a.put(s.charAt(i),0);
        }
        for(int i=0;i<s.length();i++){
            a.put(s.charAt(i),a.get(s.charAt(i))+1);
        } 
        char[] x=new char[s.length()];
        int xi=0;
        for(int i =0;i<order.length();i++){
            if(a.containsKey(order.charAt(i))){
                while(a.get(order.charAt(i))!=0){
                    x[xi]=order.charAt(i);
                    a.put(order.charAt(i),(a.get(order.charAt(i))-1));
                    xi++;
                }
            }
        }
        for(Map.Entry<Character,Integer> set:a.entrySet()){
            if(set.getValue()!=0){
                x[xi]=set.getKey();
                x.put(set.getkey());
                
            }
        }
        return String.valueOf(x);
    }
}