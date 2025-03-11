//The idea here is to go iterate through the order string, and for each character in order string, we check for all the character in s string and add to result
//To perform search in O(1), we take a hashmap to store the frequency of a character
//Once we add all the characters from order string in the same order in the result, we add the remaining characters from s string to result
//Time Complexity: O(m+n), where m and n are length of order string and s string respectively
//Space Complexity: O(n) for string builder
import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0 || s == null || s.length() == 0){
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder re = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i<order.length(); i++){
            Character ch = order.charAt(i);
            if(map.containsKey(ch)){
                int cnt = map.get(ch);
                while(cnt>0){
                    re.append(ch);
                    cnt--;
                }
                map.remove(ch);
            }           
        }
        for(Character ch: map.keySet()){
            int cnt = map.get(ch);
            while(cnt>0){
                re.append(ch);
                cnt--;
            }
        }
        return re.toString();
    }
}