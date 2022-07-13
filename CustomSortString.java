import java.util.HashMap;
//Time Complexity=O(m+n)
//Space Complexity=O(n)
public class CustomSortString {

    public String customSortString(String order, String s) {

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        StringBuilder result=new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            if(map.containsKey(c)){
                int j=map.get(c);
                while(j>0){
                    result.append(c);
                    j--;
                }
                map.remove(c);
            }
        }

        for(char key:map.keySet()){
            int j=map.get(key);

            while(j>0){
                result.append(key);
                j--;
            }
            // map.remove(key);
        }

        return result.toString();
    }
}
