import java.util.*;

public class CustomSortString{

    //Sanitization
    //Save the string in in a DS(Either DS or int array) - To reduce the TC. 
    //Iterate the order and fetch the count from the string map. 
    //Add it to the result.
    //Return the result.

    //TC: O(max(N,M)) where N is the length or order and M is the length of the str
    //SC: O(M) As we are using hash map it will be saving all the character in the given string str.
    public String customSortString(String order, String str) {
        
        if(order == null || order.length() == 0 || str==null || str.length() == 0)  return "";
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap();
        for(int i=0;i<str.length();i++) {
            char value = str.charAt(i);
            map.put(value, map.getOrDefault(value, 0)+1);
        }
        
        for(int i=0;i<order.length();i++) {
            char value = order.charAt(i);
            appendValues(map, result, value);
        }
       
        for(Map.Entry<Character,Integer> entry:map.entrySet()) {
            appendValues(map, result, entry.getKey());
        }
        return result.toString();
        
    }
    
    private void appendValues(HashMap<Character,Integer> map, StringBuilder builder, char key) {
       int count = map.getOrDefault(key, 0);
        if(count > 0){
            for(int j=0;j<count;j++) {
                builder.append(key);
            }
            map.put(key, 0);    
        }
    }
    public static void main(String[] args) {
        CustomSortString customSortString = new CustomSortString();
        String result = customSortString.customSortString("cba", "abcd");
        System.out.println("The result is: "+result);
    }
}