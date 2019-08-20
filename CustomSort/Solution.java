import java.util.*;
class CustomSort {
    public String customSortString(String S, String T) {
        
        HashMap<Character, Integer> tmap = new HashMap<>();

        // store freq of all elemenets of T in map
        for(int i=0;i<T.length();i++){
            if(tmap.containsKey(T.charAt(i))){
                tmap.put(T.charAt(i), tmap.get(T.charAt(i))+1);
            }
            else{
                tmap.put(T.charAt(i), 1);
            }
        }

        String result = "";

        // iterate S and form result based on map
        for(int i=0;i<S.length();i++){
            if(tmap.containsKey(S.charAt(i))){
                int count = tmap.get(S.charAt(i));
                while(count > 0){
                    result = result + S.charAt(i);
                    count--;
                } 
                
                tmap.remove(S.charAt(i));
            }
        }


        // fill the remaining elements from map to result
        for(Map.Entry<Character, Integer> entry : tmap.entrySet()){
            int count = entry.getValue();

            while(count > 0){
                result = result + entry.getKey();
                count--;
            }            
        }        
        return result;
    }
}
class Solution {
    public static void main(String[] args){
        System.out.println("Custom Sort");
        CustomSort obj = new CustomSort();
        System.out.println(obj.customSortString("cba", "abcd"));
    }
}