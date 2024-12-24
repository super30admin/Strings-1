// Time complexity:  O(s + o) where s is number of characters in string s and o is number of characters in string o
// Space complexity: O(s) due to freq of characters in  HashMap and O(s) for result string. so overall Space complexity is O(s)
import java.util.HashMap;

public class CustomSortString {
    public String customSort(String order, String s){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        // create a hashmap which stores freq of characters of s
        for (char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0) +1);
        }

        // build order string
        StringBuilder result = new StringBuilder();
        for ( char c : order.toCharArray()){ // count each occurance and append to the result
            if(freqMap.containsKey(c)){
                int count = freqMap.get(c);
            for(int i =0; i < count; i ++){
                result.append(c);
            }
            freqMap.remove(c); // remove after adding to the result
            }

        }

        // append remaing charachters to the result

        for(char c : freqMap.keySet()){
            int count = freqMap.get(c);
            for ( int i =0; i <count; i++){
                result.append(c);
            }
        }
        return result.toString();

    }

    public static void main (String[] args){
        CustomSortString solution = new CustomSortString();
        String order = "cba";
        String s = "abcd";
        String result = solution.customSort(order, s);
        System.out.println(result);
    }

}
