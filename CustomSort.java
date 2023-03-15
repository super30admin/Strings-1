import java.util.*;
public class CustomSort {
    //create a freq map for s and then for each char in order, append to
    // result string that char for those many times
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> freqMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!freqMap.containsKey(c)){
                freqMap.put(c,1);
            }
            else{
                freqMap.put(c,freqMap.get(c)+1);
            }
        }

        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            if(freqMap.containsKey(c)){
                int freq = freqMap.get(c);
                for(int j=0;j<freq;j++){
                    result.append(c);
                }
                freqMap.remove(c);
            }

        }

        for(Character remain:freqMap.keySet()){
            int freq = freqMap.get(remain);
            for(int j=0;j<freq;j++){
                result.append(remain);
            }
        }
        return result.toString();
    }
}
