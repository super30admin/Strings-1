import java.util.HashMap;

public class CustomSortString {
    public static String customSortString(String order, String s){
        StringBuilder sb = new StringBuilder();
        //create a hashmap to store s and its frequency
        HashMap<Character, Integer> map = new HashMap<>();
        //add s in map
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        //loop through order and get the count
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int cnt = map.get(ch);
                for(int k=0;k<cnt;k++){
                    sb.append(ch);
                }
                map.remove(ch); //remove all the elements existing in order so that map will be left with remaining elements
            }
        }
        //find and add remaining elements to result
        for(char ch:map.keySet()){
            int cnt=map.get(ch);
            for(int k=0;k<cnt;k++){
                sb.append(ch);
            }
        }
        return sb.toString();


    }
    public static void main(String args[]){
        String order = "bcafg";
        String s = "abcd";
        System.out.println("CustomSortString is: " +customSortString(order,s));
    }
}
